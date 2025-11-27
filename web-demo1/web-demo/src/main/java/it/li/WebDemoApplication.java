package it.li;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("it.li.mapper")
@SpringBootApplication
public class WebDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebDemoApplication.class, args);
    }

}
