package Formulaire.example.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Linda",
                        email = "Linda@hs-worms.de",
                        url = "Lindaa@hs-worms.de"
                ),
                description = "OpenApi documentation pour le Formulair",
                title = "OpenApi Formulair",
                version = "1.0"
        ),
        servers = @Server(
                description = "Local ENV",
                url = "http://localhost:8080"
        )

)

public class OpenApiConfig {
}

