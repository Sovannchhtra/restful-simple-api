package com.spring.restfulsimpleapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Data Analytic Restful API",
                description = "This is a free api for public usage!",
                contact = @Contact(
                        name = "Nai Sovannchhaktra",
                        email = "sovannchaktra@gmail.com",
                        url = "www.facebook.com/tra"
                )
        )

)
public class RestfulSimpleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulSimpleApiApplication.class, args);
    }

}
