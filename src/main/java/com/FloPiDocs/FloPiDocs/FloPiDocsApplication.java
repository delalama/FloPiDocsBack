package com.FloPiDocs.FloPiDocs;

import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
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
                springFoxTitle,
                springFoxDescription,
                springFoxVersion,
                springFoxTerms,
                new springfox.documentation.service.Contact(springFoxAuthor, springFoxUrl, springFoxEmail),
                springFoxLicense,
                springFoxUrl,
                Collections.emptyList());
    }

    @Value("${springFox.Title}")
    private String springFoxTitle;

    @Value("${springFox.Description}")
    private String springFoxDescription;

    @Value("${springFox.Version}")
    private String springFoxVersion;

    @Value("${springFox.Terms}")
    private String springFoxTerms;

    @Value("${springFox.Author}")
    private String springFoxAuthor;

    @Value("${springFox.License}")
    private String springFoxLicense;

    @Value("${springFox.Url}")
    private String springFoxUrl;

    @Value("${springFox.Email}")
    private String springFoxEmail;

}
