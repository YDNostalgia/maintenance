package com.gxa.config;

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
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("webapi")
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gxa.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("维修管理系统接口文档")
                .description("维修管理系统接口测试")
                .version("1.1.3")
                .contact(new Contact("团队名称", "https://github.com/YDNostalgia/maintenance", "邮箱"))
                .termsOfServiceUrl("")
                .license("")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}

