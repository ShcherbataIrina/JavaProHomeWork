package ua.ithillel.lesson23_patterns;

import org.junit.jupiter.api.Test;
import ua.ithillel.lesson22.Hero;
import ua.ithillel.lesson22.HeroDao;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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



      /*  List<Hero> heroes = List.of(
                Hero.builder().name("Agent 13").build(),
                Hero.builder().name("Green Arrow").build(),
                Hero.builder().name("Capitan America").build(),
                Hero.builder().name("Ben 10").build(),
                Hero.builder().name("Batman").build()
        );
        Mockito.when(mockHeroDao.findAll()).thenReturn(heroes);

        // Set up mock behavior for HeroMovieService
        Mockito.when(mockHeroMovieService.getPlayedIn("Agent 13")).thenReturn(List.of("People X"));
        Mockito.when(mockHeroMovieService.getPlayedIn("Green Arrow")).thenReturn(List.of("Arrow"));
        Mockito.when(mockHeroMovieService.getPlayedIn("Capitan America")).thenReturn(List.of("Capitan America"));
        Mockito.when(mockHeroMovieService.getPlayedIn("Ben 10")).thenReturn(List.of("Ben 10: Classic", "Ben 10: Begin", "Ben10: Around Word"));
        Mockito.when(mockHeroMovieService.getPlayedIn("Batman")).thenReturn(List.of("Dark knight knight", "Batman Begins", "Batman and Robin"));

        // Create target object and call method under test
        target = new HeroService(mockHeroDao, mockHeroMovieService);
        List<HeroDto> actualResult = target.getHeroes();

        // Verify results
        List<HeroDto> expectedResult = List.of(
                new HeroDto("Agent 13", List.of("People X")),
                new HeroDto("Green Arrow", List.of("Arrow")),
                new HeroDto("Capitan America", List.of("Capitan America")),
                new HeroDto("Ben 10", List.of("Ben 10: Classic", "Ben 10: Begin", "Ben10: Around Word")),
                new HeroDto("Batman", List.of("Dark knight knight", "Batman Begins", "Batman and Robin"))
        );
        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult.size(), actualResult.size());
    }*/
    }
}
