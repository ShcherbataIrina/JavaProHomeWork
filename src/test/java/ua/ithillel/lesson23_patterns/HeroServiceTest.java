package ua.ithillel.lesson23_patterns;

import org.junit.jupiter.api.Test;
import ua.ithillel.lesson22.Hero;
import ua.ithillel.lesson22.HeroDao;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroServiceTest {
    private HeroService target;

    @Test
    void shouldGetHeroes() {
        var mockHeroDao = Mockito.mock(HeroDao.class);
        var mockHeroMovieService = Mockito.mock(HeroMovieService.class);
        target = new HeroService(mockHeroDao, mockHeroMovieService);

        Mockito.when(mockHeroDao.findAll()).thenReturn(List.of(
                Hero.builder().build(),
                Hero.builder().build(),
                Hero.builder().build()

        ));

        assertEquals(target.getHeroes().size(), 3);
        Mockito.verify(mockHeroMovieService, Mockito.times(3)).getPlayedIn(null);

    }
}
