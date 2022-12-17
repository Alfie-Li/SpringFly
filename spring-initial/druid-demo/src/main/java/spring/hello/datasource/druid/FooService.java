package spring.hello.datasource.druid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *  演示慢sql
 */
@Repository
public class FooService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void selectForUpdate(){
        // for update ,当两个线程会等待锁释放
        jdbcTemplate.queryForObject("select id from foo where id = 1 for update", Long.class);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
