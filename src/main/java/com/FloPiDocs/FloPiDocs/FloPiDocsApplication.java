package com.FloPiDocs.FloPiDocs;

import org.springframework.beans.factory.annotation.Value;
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

/**
 * The type Flo pi docs application.
 */
@EnableSwagger2
@SpringBootApplication
public class FloPiDocsApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(FloPiDocsApplication.class, args);
    }


    /**
     * Swagger configuration docket.
     *
     * @return the docket
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
