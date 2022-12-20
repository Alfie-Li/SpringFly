# 初始化MongoDB的库及权限
## 打开mongo
    mongo -u root -p (输入创建的mongo用户和密码)
## 创建库
    use springbucks;
## 创建用户
```
    db.createUser(
        {
            user: "springbucks",
            pwd: "springbucks",
            roles: [
                {role : "readWrite", db: "springbucks"}
            ]
        }
    )
```

### 切换db
>use springbucks;

switched to db springbucks
### 展示文档集合
> show collections;

coffee
## 查看文档内容
> db.coffee.find();
> 
> { "_id" : ObjectId("63a12fdc172a246a4c3ffc3d"), "name" : "espresso", "price" : { "money" : { "currency" : { "code" : "CNY", "numericCode" : 156, "decimalPlaces" : 2 }, "amount" : "20.00" } }, "createTime" : ISODate("2022-12-20T03:45:32.051Z"), "updateTime" : ISODate("2022-12-20T03:45:32.051Z"), "_class" : "spring.hello.data.nosql.mongodemo.model.Coffee" }

## 删除文档
> db.coffee.remove({"name":"espresso""});
>
>WriteResult({ "nRemoved" : 1 }) 

