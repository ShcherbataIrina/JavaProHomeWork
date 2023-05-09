package ua.ithillel.lesson23_patterns;

import ua.ithillel.lesson22.Hero;
import ua.ithillel.lesson22.HeroDao;
import ua.ithillel.lesson22.HeroDaoImpl;

import javax.sql.DataSource;
import java.util.List;

public class HeroFabric {
    public static HeroService createService(DataSource dataSource) {
        return new HeroService(createDao(dataSource), createMovieService());
    }

    public static HeroDao createDao(DataSource dataSource) {
        return new HeroDaoImpl(dataSource);
    }

    private static HeroMovieService createMovieService() {
        return new HeroMovieService();
    }

    public static HeroService createService(List<Hero> heroes) {
        return new HeroService(new DummyHeroDao(heroes), createMovieService());

    }
}
