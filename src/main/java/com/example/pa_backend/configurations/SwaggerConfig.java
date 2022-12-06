package com.example.pa_backend.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                                 .title("Lotus API")
                                 .description("Lotus API")
                                 .version("0.0.1-SNAPSHOT")
                                 .license("MIT")
                                 .licenseUrl("https://opensource.org/licenses/MIT")
                                 .build())
                .select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }

}