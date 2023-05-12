package ua.ithillel.lesson29_spring_core;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ua.ithillel.lesson22.HeroDaoImpl;
import ua.ithillel.lesson23_patterns.HeroMovieService;
import ua.ithillel.lesson23_patterns.HeroService;

import javax.sql.DataSource;

import static ua.ithillel.lesson23_patterns.HeroFabric.createService;

@Configuration
@ComponentScan("ua.ithillel.lesson29_spring_core")
@PropertySource("classpath:application.properties")
public class HeroConfiguration {

    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public HeroService heroService(DataSource dataSource) {
        return createService(dataSource);
    }

    @Bean
    public HeroDaoImpl heroDao(DataSource dataSource) {
        return new HeroDaoImpl(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setDatabaseName("Hero");
        ds.setUser(userName);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    public HeroMovieService heroMovieService() {
        return new HeroMovieService();
    }
}
