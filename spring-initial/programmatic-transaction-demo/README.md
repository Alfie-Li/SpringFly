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

## 事务隔离级别
ISOLATION_READ_UNCOMMITED 1   脏读  不可重复读 幻读
ISOLATION_READ_COMMITED   2        不可重复读 幻读
ISOLATION_REPEATABLE_READ 3                 幻读
ISOLATION_SEARIALIZABLE   4 
它的默认值是-1,依据数据库的隔离级别