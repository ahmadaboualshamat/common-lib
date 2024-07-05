package com.commonlib.config;

import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
//@ConfigurationProperties("liquibaseProperties")
@EnableConfigurationProperties(LiquibaseProperties.class)
public class LiquibaseConfig {
    private DataSource dataSource;

    private LiquibaseProperties properties;

    public LiquibaseConfig(DataSource dataSource, LiquibaseProperties properties) {
        this.dataSource = dataSource;
        this.properties = properties;
    }

//    @Bean
//    public SpringLiquibase liquibase() {
//        SpringLiquibase liquibase = new SpringLiquibase();
////        properties.setChangeLog("classpath:/db/changelog/db.changelog-common-lib-master.xml");
//        liquibase.setChangeLog(this.properties.getChangeLog());
//        liquibase.setContexts(this.properties.getContexts());
//        liquibase.setDataSource(this.dataSource);
//        liquibase.setDefaultSchema(this.properties.getDefaultSchema());
//        liquibase.setDropFirst(this.properties.isDropFirst());
//        liquibase.setShouldRun(this.properties.isEnabled());
//        return liquibase;
//    }

}