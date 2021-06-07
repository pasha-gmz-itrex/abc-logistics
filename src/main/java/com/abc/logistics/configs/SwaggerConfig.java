package com.abc.logistics.configs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        List<Parameter> globalParameters = new ArrayList<>();

        Parameter tokenAuthParameter = new ParameterBuilder()
            .name("Authorization")
            .description("Access token")
            .modelRef(new ModelRef("string"))
            .parameterType("header")
            .required(true)
            .build();

        globalParameters.add(tokenAuthParameter);

        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.abc.logistics"))
            .paths(PathSelectors.any())
            .build()
            .pathMapping("/")
            .globalOperationParameters(globalParameters)
            .useDefaultResponseMessages(false)
            .genericModelSubstitutes(Optional.class);
    }
}
