package com.douglas.freire;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket apiConfigDocs() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.douglas.freire"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(infoDocs());
	}
	
	private ApiInfo infoDocs() {
		return new ApiInfo(
				"Api Rest Contatos", 
				"Serviço de cadastrado de contatos", 
				"1.0", "Terms of service", 
				new Contact(
						"Douglas Freire", 
						"https://douglasfreire.com", 
						"douglasfreire20@gmail.com"), 
				"Apache License Version 2.0", 
				"Url", 
				new ArrayList<VendorExtension>());
	}

}
