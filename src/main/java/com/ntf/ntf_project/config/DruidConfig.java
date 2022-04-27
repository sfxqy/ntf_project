package com.ntf.ntf_project.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangjie
 */
@Configuration
public class DruidConfig {

  @Value("${spring.datasource.minEvictableIdleTimeMillis}")
  private long minEvictableIdleTimeMillis;

  @Value("${spring.datasource.maxEvictableIdleTimeMillis}")
  private long maxEvictableIdleTimeMillis;

  @ConfigurationProperties(prefix = "spring.datasource")
  @Bean
  public DataSource druidDataSource() {
    DruidDataSource druidDataSource = new DruidDataSource();
    druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
    druidDataSource.setMaxEvictableIdleTimeMillis(maxEvictableIdleTimeMillis);
    return druidDataSource;
  }
}