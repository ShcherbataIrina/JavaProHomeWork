package ua.ithillel.lesson23_patterns;

import ua.ithillel.lesson22.HeroDaoImpl;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

    public class Main {

        public static void main(String[] args) {
        var dataSource = dataSource();
            var service = HeroFabric.createService(dataSource);
            var dao = new HeroDaoImpl(dataSource);

            // Find all heroes
            System.out.println("All heroes:");
            dao.findAll();
            System.out.println();

            // Find heroes by name
            var name = "Superman";
            System.out.printf("Heroes with name %s:%n", name);
            dao.findByName(name).forEach(System.out::println);
            System.out.println();
        }

        private static DataSource dataSource() {
            var ds = new PGSimpleDataSource();
//        ds.setServerNames(new String[]{"localhost"});
            ds.setDatabaseName("Hero");
            ds.setUser("postgres");
            ds.setPassword("ira");
            return ds;
        }

}
