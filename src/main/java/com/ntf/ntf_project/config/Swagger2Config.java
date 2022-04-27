package com.ntf.ntf_project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//注解开启 swagger2 功能
@EnableSwagger2
public class Swagger2Config {

  //是否开启swagger，正式环境一般是需要关闭的
  @Value("${swagger.enabled:false}")
  private boolean enableSwagger;

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .pathMapping("/")
        //是否开启 (true 开启  false隐藏。生产环境建议隐藏)
        .enable(enableSwagger)
        .select()
        //扫描的路径包,设置basePackage会将包下的所有被@Api标记类的所有方法作为api
        .apis(RequestHandlerSelectors.basePackage("com.iyiou.yiou"))
        //指定路径处理PathSelectors.any()代表所有的路径
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        //设置文档标题(API名称)
        .title("SpringBoot中使用Swagger2构建RESTful接口")
        //文档描述
        .description("亿欧网接口文档")
        //服务条款URL
        .termsOfServiceUrl("http://127.0.0.1:8080/")
        //版本号
        .version("1.0")
        .build();
  }

}
