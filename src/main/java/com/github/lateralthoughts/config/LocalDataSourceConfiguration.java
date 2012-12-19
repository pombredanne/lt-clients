package com.github.lateralthoughts.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.PropertyResolver;

import javax.inject.Inject;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
@Profile("local")
public class LocalDataSourceConfiguration implements DataSourceConfiguration {

    @Inject
    private PropertyResolver properties;

    @Bean
    @Override
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName($("ds.driver"));
        dataSource.setUrl($("ds.url"));
        dataSource.setUsername($("ds.username"));
        dataSource.setPassword($("ds.password"));
        return dataSource;
    }

    private String $(String key) {
        return properties.getProperty(key);
    }
}
