package com.kj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2   // 开启Swagger2
public class SwaggerConfig{

    // 配置了Swagger的Docker的Bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("mingyuexinc")
                // 配置是否启用Swagger，填入一个boolean值
                .enable(true)
                .select()
                // basePackage() 指定包下的接口都会被选择
                // any() 所有接口都选择
                // none() 所有接口都不选择
                // withMethodAnnotation() 选择方法上的注解作用的接口，参数是注解的类对象
                // withClassAnnotation() 选择类上的注解作用的接口，参数是注解的类对象

                // RequestHandlerSelectors 配置请求处理选择器，用来配置选择哪些api
                .apis(RequestHandlerSelectors.basePackage("com.kj.controller"))
                // PathSelectors 路径选择器，指定选择的接口路径
                .paths(PathSelectors.ant("/**"))
                .build();
    }

    // 配置swagger信息
    private ApiInfo apiInfo(){

        // 作者信息
        Contact concat = new Contact("mingyuexinc", "https://github.com/mingyuexinc", "mingyuexinc@gmail.com");

        return new ApiInfo(
                "Api Documentation",
                "Api Documentation",
                "v1.0",
                "https://github.com/mingyuexinc",
                 concat,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}
