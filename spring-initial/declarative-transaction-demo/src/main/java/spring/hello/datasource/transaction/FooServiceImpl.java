package spring.hello.datasource.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FooServiceImpl implements FooService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FooService fooService;

    @Override
    @Transactional
    public void insertRecord() {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('AAA')");
    }

    @Override
    // 碰到RollbackException异常才回滚（如何回滚）
    @Transactional(rollbackFor = RollbackException.class)
//    @Transactional(rollbackFor = RollbackException.class, propagation = Propagation.REQUIRES_NEW)
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('BBB')");
        throw new RollbackException();
    }

    @Override
    public void invokeInsertThenRollback() throws RollbackException {
        // 内部调用 带 transaction 方法
        // 内部调用，但不会走到apo代理类，处理这些方法的增强
//        insertThenRollback();
        // 该用代理类来调用，就可以了
        fooService.insertThenRollback();
        // 通过insertThenRollback 设置 propagation.new or nested这两个配置下，验证依赖的事务影响情况（new 不影响，nested会影响）
    }


}
