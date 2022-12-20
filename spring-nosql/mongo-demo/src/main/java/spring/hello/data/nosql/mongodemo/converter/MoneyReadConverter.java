package spring.hello.data.nosql.mongodemo.converter;


import org.bson.Document;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;

/**
 *  mongodb取到一个document会做类型转换
 *  这里把document转换为money;
 *  序列话的时候，会自动把money转换为bson格式对象
 *  可以定义 MongoCustomConversions bean加载启用
 *  可以查看spring data mongodb 如何在spring boot当中做配置的
 *  MongoDatabaseFactoryDependentConfiguration.mongoTemplate(MongoDatabaseFactory factory, MongoConverter converter)
 *  => MongoDataAutoConfiguration -> @Import({MongoDataConfiguration.class => mongoCustomConversions => new MongoCustomConversions(Collections.emptyList())
 */
public class MoneyReadConverter implements Converter<Document, Money> {
    @Override
    public Money convert(Document source) {
        Document money = (Document) source.get("money");
        double amount = Double.parseDouble(money.getString("amount"));
        String currency = ((Document) money.get("currency")).getString("code");
        return Money.of(CurrencyUnit.of(currency), amount);
    }
}
