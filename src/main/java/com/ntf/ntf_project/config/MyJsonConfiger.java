package com.ntf.ntf_project.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import java.nio.charset.StandardCharsets;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 启用FastJson.
 */
// https://www.cnblogs.com/skyblue-li/p/5946117.html
@Configuration
public class MyJsonConfiger {

  /**
   * 通过@Bean注解.
   */
  @Bean
  public HttpMessageConverters fastJsonHttpMessageConverters() {

    // 1.定义一个消息转换对象convert
    FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
    fastConverter.setDefaultCharset(StandardCharsets.UTF_8);
    // 2.添加fastJson配置信息，是否需要格式化
    FastJsonConfig fastJsonConfig = new FastJsonConfig();
    fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
        SerializerFeature.WriteMapNullValue,
        SerializerFeature.WriteNullNumberAsZero,
        SerializerFeature.WriteNullListAsEmpty,
        SerializerFeature.WriteNullStringAsEmpty,
        SerializerFeature.WriteNullBooleanAsFalse);

    // 3.在convert添加配置信息
    fastConverter.setFastJsonConfig(fastJsonConfig);

    return new HttpMessageConverters(fastConverter);
  }
}
