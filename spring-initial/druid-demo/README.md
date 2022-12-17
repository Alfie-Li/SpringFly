# spring boot 配置druid
1. 引入Druid依赖，并在原生springboot jdbc排除HikariCP 
2. spring.datasource.druid配置连接池参数
3. 过滤器
    1. spring.datasource.druid.filters=conn,config,stat,slf4j
    2. META-INF/druid-fiter.properties中druid.filters.conn=指定过滤器实现类
    3. 过滤器实现类实现FilterEventAdapter方法
   
4. 慢sql日志
   spring.datasource.druid.filter.stat.enabled=true
   spring.datasource.druid.filter.stat.log-slow-sql=true
   // 超过3s
   spring.datasource.druid.filter.stat.slow-sql-millis=3000
5. 注意
   1. 没特殊情况，不要在生产环境打开监控的servlet
   2. 没有连接泄漏的情况下，不要开启removeAbandoned
   3. testxx的使用需要注意
   4. 无比配置合理的超时时间