package edu.marcus.rest.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import edu.marcus.rest.controller.BookResource;
import io.swagger.v3.jaxrs2.integration.resources.AcceptHeaderOpenApiResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@ApplicationPath("rest")
@OpenAPIDefinition(info =
	@Info(title = "Open API 3.0 Example",
		version = "0.0.1",
		description = "Open API 3.0 example for educational purpose",
		license = @License(name = "Apache 2.0", url = "http://foo.bar"),
		contact = @Contact(name = "Marcus Vinícius", email = "marcusvcsilva@gmail.com")
	)
)
public class JerseyConfiguration extends ResourceConfig {

	@PostConstruct
	public void setUp() {
		register(BookResource.class);
		register(OpenApiResource.class);
		register(AcceptHeaderOpenApiResource.class);
	}

}
