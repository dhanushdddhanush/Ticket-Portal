package com.ticket.tickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Ticket Management", version = "1.0", description = "This API Provides Operations For Ticket Management, We Can perform Add Tickets, Assign Tickets"))
@EnableJpaRepositories("com.ticket.repository")
@EntityScan("com.ticket.entity")
@ComponentScan("com.ticket")
public class TicketsApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(TicketsApplication.class, args);
	}

}
