# spring 事务抽象
## 一致的事务模型
1. JDBC/Hibernate/Mybatis
2. DataSource/JTA

## 事务抽象的核心接口
1. PlatformTransactionManager
    1. DataSourceTransactionManager
    2. HibernateTransactionManager
    3. JtaTransactionManager
2. TransactionDefinition
    1. Propagation
    2. Isolation
    3. Timeout
    4. Read-only status

3. void commit(TransactionStatus status)
4. void rollback(TransactionStatus status)
5. TransactionStatus getTransaction(TransactionDefinition definition)

## 事务传播特性
｜传播性                    ｜ 值 ｜  描述｜
｜ --                      ｜ -- ｜  -- ｜
｜PROPAGETION_REQUIRED     ｜ 0  ｜ 当前有事务就用当前的，没有就用新的 （默认 ）｜
｜PROPAGETION_SUPPORTS     ｜ 1  ｜ 事务可有可无,不是必须的 ｜
｜PROPAGETION_MANDATORY    ｜ 2  ｜ 当前一定要有事务，不然就抛出异常｜
｜PROPAGETION_REQUIRES_NEW ｜ 3  ｜ 无论是否有事务，都起个新的事务｜
｜PROPAGETION_NOT_SUPPORTED｜ 4  ｜ 不支持事务，按非事务方式运行｜
｜PROPAGETION_NEVER        ｜ 5  ｜ 不支持事务， 如果有事务就抛出异常｜
｜PROPAGETION_NESTED       ｜ 6  ｜ 如果当前有事务，就在当前事务里另起一个事务 （里面有自己的事务状态，回滚不会影响外面）｜

propagetion_new && nested区别：
new 两个事务没有区别 ； nested 两个事务有关联，外部事务回滚，内部嵌套事务也会回滚
## 事务隔离级别
ISOLATION_READ_UNCOMMITED 1   脏读  不可重复读 幻读
ISOLATION_READ_COMMITED   2        不可重复读 幻读
ISOLATION_REPEATABLE_READ 3                 幻读
ISOLATION_SEARIALIZABLE   4
它的默认值是-1,依据数据库的隔离级别

## 基于注解的配置方式
1. 开启事务注解的方式
    1. @EnableTransactionManager
    2. <tx:annotation-driven/>

2. 一些配置：
    1. proxyTargetClass
    2. mode
    3. order
3. @Transactional
   1. transactionManager
   2. propagation
   3. isolation
   4. timeout
   5. readOnly
   6. 怎么判断回滚

类用cglib类做增强， 接口proxy

##事务的本质
spring的声明式事务本质是通过aop来增强了类的功能
spring的aop本质就是为类做了一个代理
    看似在调用自己写的类，实际用的是增强后的代理类

## 内部调用带事务的方法，解决办法
访问增强后的代理类的方法，而非直接访问自身的方法