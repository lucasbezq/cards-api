package com.github.lucasbezq.ms_credit_rating;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableRabbit
public class MsCreditRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCreditRatingApplication.class, args);
	}

}
