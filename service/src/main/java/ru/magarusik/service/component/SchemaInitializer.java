package ru.magarusik.service.component;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class SchemaInitializer implements BeanPostProcessor {

    @Value("${spring.liquibase.default-schema}")
    private String schemaName;

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean,
                                                 @NonNull String beanName) {
        if (bean instanceof DataSource dataSource) {
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.execute(String.format("CREATE SCHEMA IF NOT EXISTS %s", schemaName));
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return bean;
    }
}
