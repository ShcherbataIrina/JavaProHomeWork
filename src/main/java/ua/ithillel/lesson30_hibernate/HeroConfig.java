package ua.ithillel.lesson30_hibernate;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ua.ithillel.lesson30_hibernate")
public class HeroConfig {
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        var sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("ua.ithillel.lesson30_hibernate");
        return sessionFactory;
    }

    @Bean
    private static DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setDatabaseName("Hero");
        ds.setUser("postgres");
        ds.setPassword("ira");
        return ds;
    }
}
