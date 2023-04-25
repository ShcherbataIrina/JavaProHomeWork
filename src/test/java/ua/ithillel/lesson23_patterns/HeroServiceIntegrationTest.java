package ua.ithillel.lesson23_patterns;

import org.junit.jupiter.api.Test;
import ua.ithillel.lesson22.Hero;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroServiceIntegrationTest {
    private final HeroService target = HeroFabric.createService(List.of(
            Hero.builder().name("Hurry Porter").build(),
            Hero.builder().name("Agent 007").build(),
            Hero.builder().name("Green Arrow").build(),
            Hero.builder().name("Batman").build(),
            Hero.builder().name("Capitan America").build()
    ));

    @Test
    void shouldReturnListOfHeroes() {
        var listHeroesDto = target.getHeroes();

        List<Hero> expect = new ArrayList<>(List.of(
                Hero.builder().name("Hurry Porter").build(),
                Hero.builder().name("Agent 007").build(),
                Hero.builder().name("Green Arrow").build(),
                Hero.builder().name("Batman").build(),
                Hero.builder().name("Capitan America").build()
        ));

        assertEquals(expect.size(), listHeroesDto.size());

    }
}