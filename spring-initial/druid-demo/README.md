# spring boot 配置druid
1. 引入Druid依赖，并在原生springboot jdbc排除HikariCP 
2. spring.datasource.druid配置连接池参数
3. 过滤器
    1. spring.datasource.druid.filters=conn,config,stat,slf4j
    2. META-INF/druid-fiter.properties中druid.filters.conn=指定过滤器实现类
    3. 过滤器实现类实现FilterEventAdapter方法