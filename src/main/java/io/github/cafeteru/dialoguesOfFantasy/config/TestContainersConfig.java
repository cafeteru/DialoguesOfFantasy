package io.github.cafeteru.dialoguesOfFantasy.config;

import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;

@Configuration
public class TestContainersConfig {

    private static final PostgreSQLContainer<?> postgresContainer =
            new PostgreSQLContainer<>("postgres")
                    .withDatabaseName("test")
                    .withUsername("user")
                    .withPassword("password");

    static {
        try {
            postgresContainer.start();
        } catch (IllegalStateException e) {
            throw new RuntimeException("Docker isn't running or is failing", e);
        }
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(postgresContainer.getJdbcUrl());
        dataSource.setUsername(postgresContainer.getUsername());
        dataSource.setPassword(postgresContainer.getPassword());
        return dataSource;
    }

    @PreDestroy
    public void stopContainer() {
        postgresContainer.stop();
    }
}
