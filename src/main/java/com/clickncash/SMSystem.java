package com.clickncash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync(proxyTargetClass = true)
@SpringBootApplication
@EnableScheduling
@PropertySource(value = "classpath:message.properties")
public class SMSystem extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SMSystem.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SMSystem.class);
    } 
}
