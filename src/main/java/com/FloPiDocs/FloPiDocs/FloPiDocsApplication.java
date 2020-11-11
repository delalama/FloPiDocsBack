package com.FloPiDocs.FloPiDocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@SpringBootApplication
public class FloPiDocsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FloPiDocsApplication.class, args);
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

}
