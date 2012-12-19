package com.github.lateralthoughts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("com.github.lateralthoughts")
@EnableJpaRepositories("com.github.lateralthoughts.repository")
@EnableTransactionManagement
public class MainConfiguration {

    private static final String DB_DIALECT = "org.hibernate.dialect.MySQL5Dialect";

    @Inject
    private DataSourceConfiguration dataSourceConfiguration;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSourceConfiguration.dataSource());
        bean.setPackagesToScan("com.github.lateralthoughts.domain");
        bean.setJpaVendorAdapter(jpaVendorAdaptor());
        bean.setJpaPropertyMap(getJpaProperties());
        return bean;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdaptor() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform(DB_DIALECT);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(false);
        return vendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    private Map<String,?> getJpaProperties() {
        HashMap<String, String> properties = new HashMap<String, String>();
        properties.put("hibernate.dialect", DB_DIALECT);
        return properties;
    }
}
