package com.clickncash.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		List<ResponseMessage> list = new java.util.ArrayList<>();
		list.add(new ResponseMessageBuilder().code(200).message("Success").build());
		list.add(new ResponseMessageBuilder().code(400).message("Bad Request").build());
		list.add(new ResponseMessageBuilder().code(401).message("Unauthorized").build());

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.vandiest")).paths(PathSelectors.any()).build().pathMapping("/")
				.globalResponseMessage(RequestMethod.POST, list).globalResponseMessage(RequestMethod.DELETE, list)
				.globalResponseMessage(RequestMethod.PUT, list).globalResponseMessage(RequestMethod.GET, list)
				.globalOperationParameters(Arrays.asList(headerParam));
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("Van Diest API Documentation")
				.description("Society Management System").version("1.0")
				.contact(new Contact("Nobious", "http://www.nobious.com", "info@nobious.com")).build();
	}

	Parameter headerParam = new ParameterBuilder().name("Authorization").defaultValue("Bearer ").parameterType("header")
			.modelRef(new ModelRef("string")).description("JWT Token").required(true).build();
}
