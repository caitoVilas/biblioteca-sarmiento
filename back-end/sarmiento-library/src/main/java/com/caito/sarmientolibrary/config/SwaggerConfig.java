package com.caito.sarmientolibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.caito"))
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Sarmiento Library")
                .description("Sarmiento Library API reference for developers \n" +
                        "library management system manages book partners and loans")
                .termsOfServiceUrl("www.terms.com")
                .contact(new Contact("Caito Vilas",
                        "https://www.linkedin.colibrary management system manages book partners and loansm/in/caito-vilas-4179291b2/",
                        "caitocd@gmail.com"))
                .license("Caito licence")
                .licenseUrl("http://licence.com")
                .version("1.0")
                .build();
    }
}
