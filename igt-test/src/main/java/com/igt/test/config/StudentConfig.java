package com.igt.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@PropertySource(value={"classpath:application.properties"})
public class StudentConfig extends AbstractMongoConfiguration {

	@Value("${mongodb.ip}")
	private String hostIp;
	
	@Value("${mongodb.db}")
	private String dataBase;
	
	public String getDatabaseName() {
		return dataBase;
	}
	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient(hostIp);
	}
	
	@Bean(name="mongoOperations")
    public MongoOperations mongoFactory() throws Exception {
		MongoOperations mongoOps = new MongoTemplate(mongo(), getDatabaseName());
		return mongoOps;
    }
}