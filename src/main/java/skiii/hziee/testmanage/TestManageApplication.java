package skiii.hziee.testmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@SpringBootApplication
//public class TestManageApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(TestManageApplication.class, args);
//    }
//
//}

@SpringBootApplication
public class TestManageApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
        return springApplicationBuilder.sources(TestManageApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(TestManageApplication.class, args);
    }
}
