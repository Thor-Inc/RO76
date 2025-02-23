package pl.sda.spring.jdbcTemplate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public DataSource dataSource() {
        var dataSource =  new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/fruit");
        dataSource.setUsername("root");
        dataSource.setPassword("#insecure#");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
