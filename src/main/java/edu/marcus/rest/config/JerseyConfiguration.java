package edu.marcus.rest.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import edu.marcus.rest.controller.BookResource;

@Configuration
@ApplicationPath("rest")
public class JerseyConfiguration extends ResourceConfig {


	@PostConstruct
	public void setUp() {
		register(BookResource.class);
		//register(GenericExceptionMapper.class);
	}

}
