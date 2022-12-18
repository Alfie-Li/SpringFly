## JPA为对象关系映射提供了一种基于POJO的持久化模型
    1. 简化数据持久化代码的开发工作
    2. 为Java社区屏蔽不同持久化API的差异
    2006年，JPA1.0作为JSR 220 的一部分正式发布

## SPRING DATA
在保留底层存储特性的同时，提供相对一致的、基于Spring的编程模型
### 主要模块：
    1. spring data commons
    2. spring data jdbc
    3. spring data jpa
    4. spring data redis
### 引入方式
```
 <dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-releasetrain</artifactId>
            <version>Lovelace-SR4</version>
            <scope>import</scope>
            <type>pom</type>
        </denpendency>
    </dependencies>
 </dependencyManagement>
```
spring boot 可以引入 spring-boot-starter-data-jpa

## 常用JPA注解
### 实体
    1. @Entity @MappedSuperclass
    2. @Table(name)
### 主键
    1. @Id
        @GeneratedValue(strategy,generator)
        @SequenceGenerator(name, sequenceName)
### 映射
    1. @Column(name, nullable, length, insertable, updatable)
    2. @JoinTable(name)、 @JoinColumn(name) 表的关联
### 关系
    1. @OneToOne @OneToMany @ManyToOne @ManyToMany 表的关系
    2. @OrderBy

## project lomback
    1. @Getter/@Setter
    2. @ToString
    3. @NoArgsConstructor @RequireArgsConstructor @AllArgsConstructor
    4. @Data (相当于1，2)
    5. @Builder
    6. @Slf4j @CommonsLog @Log4j2

## 完整案例
    1. 时序图
    2. 流程图

    