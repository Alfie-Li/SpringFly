package spring.hello.data.mybatis.generator;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@Slf4j
//@MapperScan("spring.data.mybatis.mapper")
public class MybatisGeneratorDemoApplication implements ApplicationRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
   
    public static void main(String[] args) {
        SpringApplication.run(MybatisGeneratorDemoApplication.class, args);
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        final List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from t_coffee");
        System.out.println(list.size());
        generateArtifacts();
//        playWithArtifacts();
    }

    private void generateArtifacts() throws Exception {
        List<String> warnings = new ArrayList<>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
//        File configFile = new File("/Users/alfie/workspace/code/learn/learn-spring/hello-spring/spring-or-mapping/mybatis-generator-demo/src/main/resources/generatorConfig.xml");
        Configuration config = cp.parseConfiguration(
//                configFile
                this.getClass().getResourceAsStream("spring-or-mapping/mybatis-generator-demo/generatorConfig.xml")
        );
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    private void playWithArtifacts() {

    }


}
