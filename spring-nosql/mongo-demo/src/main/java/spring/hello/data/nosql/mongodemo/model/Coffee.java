package spring.hello.data.nosql.mongodemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
// 标明是哪一个文档，mongod collect
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    @Id
    // @表明Object id ，可以根据id auto-sharding,去处理数据分片
    private String id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
