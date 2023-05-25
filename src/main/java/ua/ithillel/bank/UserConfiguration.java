package ua.ithillel.bank;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class UserConfiguration {
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setDatabaseName("Bank");
        ds.setUser(userName);
        ds.setPassword(password);
        return ds;
    }

}
