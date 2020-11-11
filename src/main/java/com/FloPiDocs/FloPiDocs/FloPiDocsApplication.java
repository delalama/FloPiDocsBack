package com.FloPiDocs.FloPiDocs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@SpringBootApplication
public class FloPiDocsApplication implements ApplicationRunner {
		@Autowired
		public static final Logger logger = LogManager.getLogger(FloPiDocsApplication.class);

		public static void main(String[] args) {
		SpringApplication.run(FloPiDocsApplication.class, args);
	}

//	MODEL MAPPER
	@Configuration
	public static class ApplicationConfig {
	//Guille , quiero entender pk se hace esto aquí, es un requisito del propio ModelMapper?, pk no encuentro la respuesta por mí mismo?
//		Es correcto pensar que SOLO con instanciarlo con un @Autowired en el CONTROLLER de turno debería funcionar?
		@SuppressWarnings("UnnecessaryLocalVariable")
        @Bean
		public ModelMapper modelMapper() {
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper;
		}
	}

/*
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter((Filter) new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/token").permitAll()
					.anyRequest().authenticated();
		}
	}
*/

//	SWAGGER
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.FloPiDocs.FloPiDocs.Content.controller"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"FlopiDocs Swagger",
				"Endpoints tester",
				"1.0.1",
				"",
				new springfox.documentation.service.Contact("Jesús de la Lama", "https://github.com/delalama", "elaltas@gmail.com"),
				"API License",
				"https://github.com/delalama",
				Collections.emptyList());
	}

//	LOG4J
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("LOG4J2 messages");
		logger.info("______________");
		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("Hey, This is a warning!");
		logger.error("Oops! We have an Error. OK");
		logger.fatal("Damn! Fatal error. Please fix me.");
		logger.info("______________");
	}
}
