package com.github.lateralthoughts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.beans.factory.annotation.Autowire.BY_TYPE;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;


@Configuration
@Import(MainConfiguration.class)
public class TestConfiguration {

    private static final String DB_DIALECT = "org.hibernate.dialect.H2Dialect";

    @Bean(destroyMethod = "shutdown", autowire = BY_TYPE)
    public DataSource dataSource() {
        EmbeddedDatabaseFactory databaseFactory = new EmbeddedDatabaseFactory();
        databaseFactory.setDatabaseName("clients");
        databaseFactory.setDatabaseType(H2);
        return databaseFactory.getDatabase();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdaptor() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform(DB_DIALECT);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        return vendorAdapter;
    }

    private Map<String,?> getJpaProperties() {
        HashMap<String, String> properties = new HashMap<String, String>();
        properties.put("hibernate.dialect", DB_DIALECT);
        return properties;
    }
}
