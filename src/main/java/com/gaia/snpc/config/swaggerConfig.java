package com.gaia.snpc.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class swaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server();
        server.setDescription("LOCAL ENV");
        server.setUrl("http://localhost:9999/api");

        Contact contact = new Contact();
        contact.setName("GAIA SARL");
        contact.setEmail("gaia@gaia.cm");

        Info info = new Info();
        info.title("SNPC SERVICE API");
        info.contact(contact);
        info.setVersion("v1.0");
        info.setDescription("Cette API expose touts les endpoints de la plateforme SNPC.");

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
