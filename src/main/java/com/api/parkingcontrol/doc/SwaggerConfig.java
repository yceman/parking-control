package com.api.parkingcontrol.doc;



import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Predicate;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;
import static org.springframework.web.servlet.mvc.method.RequestMappingInfo.paths;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Contact contact() {
        return new Contact(
                "Marcos Morais",
                "meusite.com.br",
                "mail@mail.com"
        );
    }
    private ApiInfoBuilder informationApi() {
        ApiInfoBuilder apiInfoBuilder = new  ApiInfoBuilder();
        apiInfoBuilder.title("Parking Control - API");
        apiInfoBuilder.description("API for parking lot control");
        apiInfoBuilder.version("0.02");
        apiInfoBuilder.termsOfServiceUrl("MIT");
        apiInfoBuilder.license("License - my");
        apiInfoBuilder.licenseUrl("https://localhost/license");
        apiInfoBuilder.contact(this.contact());
        return apiInfoBuilder;
    }

    @Bean
    public Docket detailsApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.api.parkingcontrol.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informationApi().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));
        return docket;
    }

}
