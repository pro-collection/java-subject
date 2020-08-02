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


### 逻辑删除
第一步， 配置 application.yml
```yml
mybatis-plus:
  mapper-locations: classpath:mapper/*.xml
#  global-config:
#    db-config:
#      id-type: uuid
  global-config:
    db-config:
      logic-not-delete-value: 0  # 逻辑未删除 默认也是这样的
      logic-delete-value: 1 # 逻辑删除的是1 默认也是这样的
```

第二步： 在 entity 中添加备注
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
    private LocalDateTime updateTime;
    private Integer version;

    @TableLogic
    @TableField(select = false) // 这个时候， 在 sql 查询就不会显示这个字段了
    private Integer deleted;
}
```

第三步使用：                              
`src/test/java/com/yanle/mybatis/plus/study/MyTest.java`


### 自动填充
比如自动填充时间等、比如每次新增或者修改的时候， 需要记录修改人是谁

第一步: 添加注解
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

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
    private Integer version;

    @TableLogic
    @TableField(select = false) // 这个时候， 在 sql 查询就不会显示这个字段了
    private Integer deleted;
}
```

第二步： 填充处理器
```java
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("insertFill!!!!");
        // 第一个参数是实体类中的名， 不是数据库中的名
        // 其实该方法虽然是可以用， 但是官方已经不推荐使用了， 可以用下面的方法
        // setInsertFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("updateFill!!!!");
//        setUpdateFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
```

第三步： 测试                             
`src/test/java/com/yanle/mybatis/plus/study/FillTest.java`

#### 自动填充优化
上面的方式， 每次调用 insert/update 都会调用自动填充处理器， 但是比如有一些 插入和更新 并不会涉及到
update_time/create_time.                            
这种情况就是一种不必要的开销。                             

可以这样解决： 使用 `metaObject.hasSetter("FieldName");`            
```
@Override
public void insertFill(MetaObject metaObject) {
    // 优化
    boolean hasSetter = metaObject.hasSetter("createTime");
    if (hasSetter) {
        System.out.println("insertFill!!!!");
        // 第一个参数是实体类中的名， 不是数据库中的名
        // 其实该方法虽然是可以用， 但是官方已经不推荐使用了， 可以用下面的方法
        // setInsertFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
    }
}
```

还有一种需求， 比如， 我如果我更新的时候， 我设置了某个属性， 就不需要填充， 如果我没有设置， 就自动填充
使用 `Object value = getFieldValByName("updateTime", metaObject);` 获取到我们预期的值
```
@Override
public void updateFill(MetaObject metaObject) {
    Object value = getFieldValByName("updateTime", metaObject);
    if (value == null) {
        System.out.println("updateFill!!!!");
//        setUpdateFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
```




### 参考文档
- [Spring Boot 日志配置(超详细)](https://blog.csdn.net/Inke88/article/details/75007649)