package com.yanle.mybatis.plus.study;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yanle.mybatis.plus.study.dao.UserMapper;
import com.yanle.mybatis.plus.study.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RetrieveTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectById() {
        User user = userMapper.selectById(1094592041087729666L);
        System.out.println(user);
    }

    @Test
    public void batchSelectById() {
        List<Long> ids = Arrays.asList(1087982257332887553L, 1088248166370832385L, 1088250446457389058L);
        List<User> userList = userMapper.selectBatchIds(ids);
        Assert.assertEquals(3, userList.size());
        userList.forEach(item -> System.out.println(item));
    }

    @Test
    public void selectByMap() {
        // string 必须要对应表field名称
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("manager_id", 1088248166370832385L);
        columnMap.put("name", "张雨琪");
        // 效果等价于 where name = '张雨琪' and manager_id = 1088248166370832385L
        List<User> userList = userMapper.selectByMap(columnMap);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByMapMultiple() {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("manager_id", 1088248166370832385L);
        List<User> userList = userMapper.selectByMap(columnMap);
        userList.forEach(System.out::println);
    }

    /*
    名字中包含雨并且年龄小于40
	name like '%雨%' and age<40
    * */
    @Test
    public void selectByWrapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 上面也可以类似于写成这样
        // QueryWrapper<User> query = Wrappers.<User>query();
        queryWrapper.like("name", "雨").lt("age", 40);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    名字中包含雨年并且龄大于等于20且小于等于40并且email不为空
    name like '%雨%' and age between 20 and 40 and email is not null
    * */
    @Test
    public void selectByWrapper2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 上面也可以类似于写成这样
        // QueryWrapper<User> query = Wrappers.<User>query();
        queryWrapper.like("name", "雨").between("age", 20, 40).isNotNull("email");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    名字为王姓或者年龄大于等于25，按照年龄降序排列，年龄相同按照id升序排列
    name like '王%' or age>=25 order by age desc,id asc
    * */
    @Test
    public void selectByWrapper3() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 上面也可以类似于写成这样
        // QueryWrapper<User> query = Wrappers.<User>query();
        queryWrapper.likeRight("name", "王").or().ge("age", 25).orderByDesc("age")
                .orderByAsc("id");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    创建日期为2019年2月14日并且直属上级为名字为王姓
    date_format(create_time,'%Y-%m-%d')='2019-02-14' and manager_id
    in (select id from user where name like '王%')
    * */
    @Test
    public void selectByWrapper4() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 上面也可以类似于写成这样
        // QueryWrapper<User> query = Wrappers.<User>query();
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}", "2019-02-14")
                .inSql("manager_id", "select id from user where name like '王%'");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    名字为王姓并且（年龄小于40或邮箱不为空）
    name like '王%' and (age<40 or email is not null)
    * */
    @Test
    public void selectByWrapper5() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "王").and(wq -> wq.lt("age", 40).or().isNotNull("email"));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }


    /*
    名字为王姓或者（年龄小于40并且年龄大于20并且邮箱不为空）
    name like '王%' or (age<40 and age>20 and email is not null)
    * */
    @Test
    public void selectByWrapper6() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "王").or(
                wq -> wq.lt("age", 40).gt("age", 20).isNotNull("email")
        );
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    (年龄小于40或邮箱不为空）并且名字为王姓
    (age<40 or email is not null) and name like '王%'
    * */
    @Test
    public void selectByWrapper7() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.nested(qw -> qw.lt("age", 40).or().isNotNull("email"))
                .likeRight("name", "王");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    年龄为30、31、34、35
    age in (30、31、34、35)
    * */
    @Test
    public void selectByWrapper8() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("age", Arrays.asList(30, 31, 34, 35));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    只返回满足条件的其中一条语句即可
    limit 1
    * */
    @Test
    public void selectByWrapper9() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("age", Arrays.asList(30, 31, 34, 35)).last("limit 1");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    select id,name
       from user
       where name like '%雨%' and age<40
    * */
    @Test
    public void selectByWrapperSupper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name").like("name", "雨").lt("age", 40);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    select id,name,age,email
	           from user
	           where name like '%雨%' and age<40
    * */
    @Test
    public void selectByWrapperSupper2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "雨").lt("age", 40)
                .select(
                        User.class,
                        info -> !info.getColumn().equals("create_time") && !info.getColumn().equals("manager_id")
                );
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    带条件
    * */
    @Test
    public void testCondition() {
        String name = "王";
        String email = "";
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name), "name", name)
                .like(StringUtils.isNotEmpty(email), "email", email);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }
}
