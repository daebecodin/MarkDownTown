package com.daebecodin.mdt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "com.daebecodin.mdt")
public class MdtApplication {

    public static void main(String[] args) {
        SpringApplication.run(MdtApplication.class, args);
    }

}
