package com.github.lateralthoughts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
@Import(MainConfiguration.class)
public class TestConfiguration {

    private static final String DB_DIALECT = "org.hibernate.dialect.H2Dialect";

    @Bean
    public JpaVendorAdapter jpaVendorAdaptor() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform(DB_DIALECT);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        return vendorAdapter;
    }
}
