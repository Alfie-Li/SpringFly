# 认识Mybatis
 一款优秀的持久化框架，支持定制化SQL、存储过程和高级映射
 
## 在spring中使用Mybatis
    1. mybatis spring adapter (https://github.com/mybatis/spring)
    2. mybatis spring-boot-starter (https://github.com/mybatis/spring-boot-starter)

## 简单配置
    1. mybatis.mapper-locations = classpath*:mapper/**/*.xml
    2. mybatis.type-aliases-package=类型别名的包名
    3. mybatis.type-handlers-package = TypeHandler扫描包名
    4. mybatis.configuration.map-underscore-to-camel-case = true

## mapper的定义与扫描
    1. @MapperScan配置扫描位置
    2. @Mapper定义接口
    3. 映射的定义 -- xml与注解