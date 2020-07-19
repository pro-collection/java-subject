package com.yanle.mybatis.plus.demo1.system.restfulController;

import cn.hutool.core.util.IdUtil;
import com.wf.captcha.ArithmeticCaptcha;
import com.yanle.mybatis.plus.demo1.common.base.ApiResponse;
import com.yanle.mybatis.plus.demo1.common.base.Constants;
import com.yanle.mybatis.plus.demo1.common.utils.RedisUtils;
import com.yanle.mybatis.plus.demo1.common.utils.SecurityUtils;
import com.yanle.mybatis.plus.demo1.system.entity.SysUser;
import com.yanle.mybatis.plus.demo1.system.service.RedisService;
import com.yanle.mybatis.plus.demo1.system.service.SysUserService;
import com.yanle.mybatis.plus.demo1.system.vo.ImgResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class IndexRestfulController {
    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 验证码 宽度
     */
    @Value("${loginCode.width}")
    private Integer width;

    /**
     * 验证码 高度
     */
    @Value("${loginCode.height}")
    private Integer height;

    /**
     * 验证码 运算位数
     */
    @Value("${loginCode.digit}")
    private Integer digit;

    @GetMapping("/code")
    public ImgResult getCode() {
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(width, height, digit);
        // 获取运算结果
        String result = captcha.text();
        String uuid = IdUtil.simpleUUID();

        redisService.saveCode(uuid, result);
        return new ImgResult(captcha.toBase64(), uuid);
    }

    /**
     * 更新密码
     *
     * @param oldPass 旧密码
     * @param pass    新密码
     * @return 返回值
     */
    @PostMapping("/updatePassword")
    public ApiResponse updatePassword(
            @RequestParam("oldPass") String oldPass,
            @RequestParam("pass") String pass
    ) {
        // 获取用户信息
        Authentication authentication = SecurityUtils.getCurrentUserAuthentication();
        String username = (String) authentication.getPrincipal();
        String usernameRedisKey = Constants.PASSWORD_UPDATE + username;

        if (redisUtils.exists(usernameRedisKey) && redisUtils.sGetSetSize(usernameRedisKey) >= 3L)
            return ApiResponse.fail("旧密码错误次数太多了，请稍后重试");

        // 判断旧密码是否正确
        SysUser sysUser = sysUserService.findByName(username);
        if (sysUser == null) return ApiResponse.fail("获取用户信息出错，请稍后重试");
        if (!new BCryptPasswordEncoder().matches(oldPass, sysUser.getPassword())) {
            redisUtils.sSetAndTime(usernameRedisKey, Constants.PASSWORD_UPDATE_MINUTE, new Date());
            return ApiResponse.fail("旧密码不匹配,还有" + (3 - redisUtils.sGetSetSize(usernameRedisKey)) + "次机会");
        }
        sysUserService.updatePasswordById(new BCryptPasswordEncoder().encode(pass), sysUser.getId());
        if (redisUtils.exists(usernameRedisKey)) redisUtils.remove(usernameRedisKey);
        return ApiResponse.success("更新成功");
    }

    @GetMapping("/getUserInfo")
    public ApiResponse getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ApiResponse.success(authentication.getName());
    }
}
