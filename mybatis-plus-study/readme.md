# mp学习

- [注解](https://mybatis.plus/guide/annotation.html)


### 排除非表字段
方式一： 添加关键字 `transient` 不序列化                     
`private transient String remark;`

方式二： 标志位静态变量                    
`privage static String remark;`

方式三： 添加注解 `@TableField(exit=false)`                                     
```
@TableField(exit=false)
privage static String remark;
```

### AR模式
1、首先要在实体对象类上继承 Model 类
```java
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends Model<User> {
    private static final long serialVersionUID = 3660096825159993280L;
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Long managerId;
    private LocalDateTime createTime;
}
```


### 主键策略

局部策略优先级高于全局策略

#### 局部策略
```java
// 主键自增
@TableId(type = IdType.AUTO)
private Long id;

// 默认主键策略
@TableId(type = IdType.NONE)
private Long id;

// 主键需要是string类型，生成的主键的可以是UUID；
@TableId(type = IdType.UUID)
private Long id;

// 下划线字段的id, 也是字符串类型
@TableId(type = IdType.ID_WORKER_STR)
private Long id;
```

#### 全局策略
application.yml
```yml
mybatis-plus:
  mapper-locations: classpath:mapper/*.xml
  global-config:
    db-config:
      id-type: uuid
```

用到了在补充吧


### 基本配置
直接看官网吧， 没有啥好说的


### 参考文档
- [Spring Boot 日志配置(超详细)](https://blog.csdn.net/Inke88/article/details/75007649)