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

### 参考文档
- [Spring Boot 日志配置(超详细)](https://blog.csdn.net/Inke88/article/details/75007649)