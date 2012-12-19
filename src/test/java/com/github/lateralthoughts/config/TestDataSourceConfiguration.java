package com.github.lateralthoughts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;

import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

@Configuration
@Profile("test")
public class TestDataSourceConfiguration implements DataSourceConfiguration {

    @Bean(destroyMethod = "shutdown")
    @Override
    public DataSource dataSource() {
        EmbeddedDatabaseFactory databaseFactory = new EmbeddedDatabaseFactory();
        databaseFactory.setDatabaseName("clients");
        databaseFactory.setDatabaseType(H2);
        return databaseFactory.getDatabase();
    }
}
