package com.github.lucasbezq.ms_cards;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MsCardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCardsApplication.class, args);
	}

}
