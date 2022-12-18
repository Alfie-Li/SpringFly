## repository

### 开启 @EnableJpaRepositories,自动发现Repository接口实现

### Repository<T, ID> 接口
    1. CrudRepository<T, ID>
    2. PagingAndSortingRepository<T, Id>
    3. JpaRepository<T, ID>

### 定义查询
#### 根据方法名定义查询
    1. find...By... read...By... query...By... get...By...
    2. count...By...
    3. ...OrderBy...[Asc/Desc]
    4. And  Or IgnoreCase
    5. Top First Distinct
#### 分页查询
    1. PagingAndSortingRepository<T, ID>
    2. Pageable / Sort
    3. Slice<T> / Page<T> 

## Repository Bean是如何创建的
### JpaRepositoriesRegistrar
    1. 激活了@EnableJpaRepositories
    2. 返回了JpaRepositoryConfigExtension
### RepositoryBeanDefinitionRegistrarSupport.registerBeanDefinitions
    注册Repository Bean (类型是JpaRepositoryFactoryBean)
### RepositoryConfigurationExtensionSupoort.getRepositoryConfigurations
    取得Repository配置
### JpaRepositoryFactory.getTargetRepository
    创建了Repository

## 接口中的方法是如何被解释的
### RepositoryFactorySupport.getRepository添加了Advice
    1. DefaultMethodInvokingMethodInterceptor
    2. QueryExecutorMethodInterceptor
### AbstractJpaQuery.execute执行具体的查询
### 语法解析在Part中