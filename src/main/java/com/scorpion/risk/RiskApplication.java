package com.scorpion.risk;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
//开启事务
@EnableTransactionManagement

public class RiskApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskApplication.class, args);
	}
}
