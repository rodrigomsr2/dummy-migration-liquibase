package com.rodrigo.dummymigrationliquibase.infrastructure.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.logging.Logger;

@Configuration
public class DatasourceConfiguration {

    @Value("${spring.datasource.url}")
    public String url;

    @Value("${spring.datasource.util.url}")
    public String urlUtil;

    @Value("${spring.datasource.username}")
    public String username;

    @Value("${spring.datasource.password}")
    public String password;

    @Value("${spring.datasource.util.username}")
    public String usernameUtil;

    @Value("${spring.datasource.util.password}")
    public String passwordUtil;

    @Value("${spring.datasource.driverClassName}")
    public String driver;

    private static final Logger logger = Logger.getLogger(DatasourceConfiguration.class.getName());

    private DataSource getDataSource(String driver, String jdbcUrl, String username, String password) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(driver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    @Primary
    public JdbcTemplate getJdbcTemplate() {
        logger.info("Informações da conexão: \n" + url);

        DataSource dataSource = getDataSource(driver, url, username, password);

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }

    @Bean(name = "util")
    public JdbcTemplate getJdbcTemplateUtilitarios() {
        logger.info("Informações da conexão: \n" + urlUtil);

        DataSource dataSource = getDataSource(driver, urlUtil, usernameUtil, passwordUtil);

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }

}