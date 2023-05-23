package ua.ithillel.lesson31_spring_hero_MVC;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.ithillel.lesson22.HeroDaoImpl;
import ua.ithillel.lesson23_patterns.HeroFabric;

import javax.sql.DataSource;

@Configuration
public class HeroMvcConfig {
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public HeroDaoImpl heroServiceImpl() {
        return (HeroDaoImpl) HeroFabric.createDao(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setDatabaseName("Hero");
        ds.setUser(userName);
        ds.setPassword(password);
        return ds;
    }
}
