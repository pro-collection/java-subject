## 对于mybatis的研究

### springboot 接入mybatis

1、加入依赖
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>

<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.3.2</version>
</dependency>
```

2、添加mapper扫描路径                  
在application 启动项上添加
```java
@SpringBootApplication
@MapperScan(basePackages = "com.yanle.mybatis.mapper")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```

3、添加映射关系: 查看 `entity/User.java`

4、添加mapper文件： 查看 `mapper/UserMapper.java`

5、添加xml 文件： 查看 `sources/mappers/userMapper.xml`

```mysql
create database if not exists mybatisdemo;

create table if not exists tb_user
(
  id        int auto_increment,
  user_name varchar(32) default null,
  password  varchar(32) default null,
  name      varchar(32) default null,
  age       int(10)     default null,
  sex       int(2)      default null,
  birthday  datetime    default null,
  created   datetime    default null,
  updated   datetime    default null,
  primary key (id)
) engine = innoDB
  default charset = utf8;

use mybatisdemo;

INSERT INTO tb_user (user_name, password, name, age, sex, birthday, created, updated)
VALUES ('zpc', 123456, '鹏程', 22, 1, '1990-09-02', sysdate(), sysdate());

INSERT INTO tb_user (user_name, password, name, age, sex, birthday, created, updated)
VALUES ('hj', '123456', '静静', '22', '1', '1993-09-05', sysdate(), sysdate());

select * from tb_user;
```







### 参考文章
- [Mybatis教程-实战看这一篇就够了](https://blog.csdn.net/hellozpc/article/details/80878563)
- [MyBatis 快速入门和重点详解](https://blog.csdn.net/lj1314ailj/article/details/79712305)
- [mybatis mybatis-generator 代码自动生成工具](https://blog.csdn.net/w410589502/article/details/70756764)
- [MyBatis代码生成器——MyBatis Generator](https://blog.csdn.net/qq407388356/article/details/79478154)
- [PageHelper查询结果排序](https://blog.csdn.net/qq_36850813/article/details/95178080)
- [PageHelper 排序踩坑记录](https://www.jianshu.com/p/c5fa441f6066)

