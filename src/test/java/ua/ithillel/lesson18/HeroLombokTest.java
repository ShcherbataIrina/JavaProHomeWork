package ua.ithillel.lesson18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeroLombokTest {
    private HeroLombok heroLombok;

    @BeforeEach
    void setUp() {
        heroLombok = new HeroLombok();
        heroLombok.setName("Batman");
        heroLombok.setGender("Male");
        heroLombok.setAlignment("good");
        heroLombok.setSkinColor("-");
        heroLombok.setEyeColor("Blue");
        heroLombok.setPublisher("Marvel Comics");
        heroLombok.setHeight(189.4);
        heroLombok.setRace("Human");
        heroLombok.setWeight(78);
        heroLombok.setHairColor("Brown");
    }

    @Test
    void shouldGetName() {

        Assertions.assertEquals("Batman", heroLombok.getName());
    }

    @Test
    void shouldGetGender() {

        Assertions.assertEquals("Male", heroLombok.getGender());
    }

    @Test
    void shouldGetAlignment() {

        Assertions.assertEquals("good", heroLombok.getAlignment());
    }

    @Test
    void shouldGetEyeColor() {

        Assertions.assertEquals("Blue", heroLombok.getEyeColor());
    }

    @Test
    void shouldGetSkinColor() {

        Assertions.assertEquals("-", heroLombok.getSkinColor());
    }

    @Test
    void shouldGetRace() {

        Assertions.assertEquals("Human", heroLombok.getRace());
    }

    @Test
    void shouldGetWeight() {

        Assertions.assertEquals(78, heroLombok.getWeight());
    }

    @Test
    void shouldGetHeight() {

        Assertions.assertEquals(189.4, heroLombok.getHeight());
    }
}