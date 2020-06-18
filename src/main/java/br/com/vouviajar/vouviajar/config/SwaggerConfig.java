package br.com.vouviajar.vouviajar.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
import springfox.documentation.service.SecurityReference;

import com.google.common.collect.Lists;

@EnableSwagger2WebMvc
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket getApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                //.paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .pathMapping("/");
                //.securityContexts(Lists.newArrayList(securityContext()))
                //.securitySchemes(Lists.newArrayList(apiKey()))
                //.apiInfo(metaData());
    }


    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new springfox.documentation.service.AuthorizationScope("global", "accessEverything");

        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;

        return Lists.newArrayList(
                new SecurityReference("JWT", authorizationScopes));
    }

}