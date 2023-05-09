package ua.ithillel.lesson27_rest;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.ithillel.lesson22.HeroDao;
import ua.ithillel.lesson23_patterns.HeroFabric;
import ua.ithillel.lesson23_patterns.HeroService;

import javax.sql.DataSource;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    public HeroService heroService() {
        return HeroFabric.createService(dataSource());
    }

    @Bean
    public HeroDao heroDao() {
        return HeroFabric.createDao(dataSource());
    }

    public DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setDatabaseName("Hero");
        ds.setUser("postgres");
        ds.setPassword("ira");
        return ds;
    }

}
