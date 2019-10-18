package com.library.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static ApiInfo APIINFO = new ApiInfo("Awesome API Title", "Awesome API Description", "1.0",
			"urn:tos", "Subhabrata", 
			"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	
	private static Set<String> CONSUMERS = new HashSet<String>(Arrays.asList("application/json", "application/xml"));
	private static Set<String> PRODUCER = new HashSet<String>(Arrays.asList("application/json", "application/xml"));
	
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
					.consumes(CONSUMERS)
					.produces(PRODUCER)
					.apiInfo(APIINFO);
	}

}
