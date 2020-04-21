package com.lexi.musicportal.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * The configuration class for swagger
 *
 * @author Dhirendra
 *
 */

@Configuration
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
public class SwaggerConfig {

	@Value("${swagger.musicportal.copyright}")
	private String license;

	@Value("${swagger.musicportal.copyright.url}")
	private String licenseUrl;

	@Value("${swagger.musicportal.api.description}")
	private String description;

	@Value("${swagger.musicportal.api.version}")
	private String version;

	@Value("${swagger.musicportal.api.title}")
	private String title;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	@Bean
	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.title(title).version(version).license(license).description(description);
		return builder.build();
	}

}
