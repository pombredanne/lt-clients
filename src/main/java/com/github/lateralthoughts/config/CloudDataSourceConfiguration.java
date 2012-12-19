package com.github.lateralthoughts.config;

import org.cloudfoundry.runtime.env.CloudEnvironment;
import org.cloudfoundry.runtime.env.RdbmsServiceInfo;
import org.cloudfoundry.runtime.service.relational.RdbmsServiceCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.util.Collection;

@Configuration
@Profile("cloud")
public class CloudDataSourceConfiguration implements DataSourceConfiguration {

    private CloudEnvironment cloudEnvironment = new CloudEnvironment();

    @Bean
    @Override
    public DataSource dataSource() {
        Collection<RdbmsServiceInfo> serviceInfo = cloudEnvironment.getServiceInfos(RdbmsServiceInfo.class);
        RdbmsServiceCreator dataSourceCreator = new RdbmsServiceCreator();
        return dataSourceCreator.createService(serviceInfo.iterator().next());
    }
}
