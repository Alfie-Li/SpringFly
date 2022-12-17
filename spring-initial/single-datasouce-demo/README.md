#spring boot配置数据源
符合条件时才进行配置
1. datasourceautoconfiguration自动配置datasource
2. datasourcetransactionmanagerautoconfiguration自动配置datasourcetransactionmanager
3. jdbctemplateautoconfiguration自动配置jdbctemplate

##默认数据源：
1.spring boot 2.x 默认 使用 HicariCP
配置spring.datasource.hikari.*配置
优势：
1. 字节码级别优化（很多方法javaassist生成）
2. 大量小改进
    1. 用FastStatementList代替ArrayList
    2. 无锁集合
    3. 代理类的优化（比如，用invokestatic代替了invokevirtual）


2.spring boot 1.x 默认使用tomcat连接池，需要移除tomcat-jdbc依赖
spring.datasource.type=com.zaxxer.hikari.HikariDataSource

## Druid
1. 详细的监控
2. exceptionsorter
3. sql防注入
4. 内置加密配置
5. 很多拓展点
