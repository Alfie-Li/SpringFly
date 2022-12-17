#spring boot配置多数据源
1. 通过@Primary指定数据源优先级
2. 去除自动配置，手工配置多数据源
   1. @SpringBootApplication 去除数据源、事物管理器、jdbctemplate自动配置
   2. 通过不同数据源的配置，生成不同的数据源和事物管理器
   3. 代码中使用不同的数据源