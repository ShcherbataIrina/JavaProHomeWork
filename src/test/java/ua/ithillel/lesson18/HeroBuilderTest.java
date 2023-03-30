package ua.ithillel.lesson18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroBuilderTest {
    @Test
    void shouldGetName() {

        HeroBuilder heroBuilder = HeroBuilder.builder().name("Superman").build();
        assertEquals("Superman", heroBuilder.name);
    }

    @Test
    void shouldGetGender() {

        HeroBuilder heroBuilder = HeroBuilder.builder().gender("Male").build();
        assertEquals("Male", heroBuilder.gender);
    }

    @Test
    void shouldGetWeight() {

        HeroBuilder heroBuilder = HeroBuilder.builder().weight(80).build();
        assertEquals(80, heroBuilder.weight);
    }

    @Test
    void shouldGetRace() {

        HeroBuilder heroBuilder = HeroBuilder.builder().race("-").build();
        assertEquals("-", heroBuilder.race);
    }

    @Test
    void shouldGetColorEye() {

        HeroBuilder heroBuilder = HeroBuilder.builder().eyeColor("Blue").build();
        assertEquals("Blue", heroBuilder.eyeColor);
    }

    @Test
    void shouldGetPublisher() {

        HeroBuilder heroBuilder = HeroBuilder.builder().publisher("Comics CMD").build();
        assertEquals("Comics CMD", heroBuilder.publisher);
    }

    @Test
    void shouldGetSkinColor() {

        HeroBuilder heroBuilder = HeroBuilder.builder().skinColor("-").build();
        assertEquals("-", heroBuilder.skinColor);
    }

    @Test
    void shouldGetHairColor() {

        HeroBuilder heroBuilder = HeroBuilder.builder().hairColor("Black").build();
        assertEquals("Black", heroBuilder.hairColor);
    }

    @Test
    void shouldGetHeight() {

        HeroBuilder heroBuilder = HeroBuilder.builder().height(196.8).build();
        assertEquals(196.8, heroBuilder.height);
    }

    @Test
    void shouldGetAlignment() {

        HeroBuilder heroBuilder = HeroBuilder.builder().alignment("good").build();
        assertEquals("good", heroBuilder.alignment);
    }
}
