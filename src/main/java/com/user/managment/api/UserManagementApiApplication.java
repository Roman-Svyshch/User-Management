package com.user.managment.api;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Users microservice REST API Documentation",
				description = "Users microservice REST API Documentation",
				version = "V-1",
				contact = @Contact(
						name = "Roman Svyshch",
						email = "svychroman@gmail.com"
				),
				license = @License(
						name = "Apache 2.0"
				)
		),externalDocs = @ExternalDocumentation(
		description = "Users microsrvice Documentation",
		url = "here must been uri)))"
)
)
public class UserManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApiApplication.class, args);
	}

}
