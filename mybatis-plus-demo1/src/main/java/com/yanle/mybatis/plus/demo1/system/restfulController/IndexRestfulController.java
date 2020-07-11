package com.yanle.mybatis.plus.demo1.system.restfulController;

import cn.hutool.core.util.IdUtil;
import com.wf.captcha.ArithmeticCaptcha;
import com.yanle.mybatis.plus.demo1.system.vo.ImgResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexRestfulController {
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
        String uuid = IdUtil.simpleUUID();
        return new ImgResult(captcha.toBase64(), uuid);
    }
}
