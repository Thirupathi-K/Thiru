package com.igt.test.main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration(exclude={JmxAutoConfiguration.class , IntegrationAutoConfiguration.class,MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@SpringBootApplication
@ComponentScan({"com.igt.test"})
public class StudentMain extends SpringBootServletInitializer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentMain.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StudentMain.class);
	}
	public static void main(String[] args){
		SpringApplication.run(StudentMain.class, args);		
		LOGGER.info("==========StudentMain---Started====================>");
	}

}
