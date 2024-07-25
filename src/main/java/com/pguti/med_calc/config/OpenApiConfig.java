package com.pguti.med_calc.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Med Calc Api",
                description = "Test task", version = "1.0.0",
                contact = @Contact(
                        name = "Bazhenov E.I Student PGUTI "
                )
        )
)
public class OpenApiConfig {
}
