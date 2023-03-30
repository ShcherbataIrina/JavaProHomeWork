package ua.ithillel.lesson18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeroLombokTest {

    @Test
    void shouldNameGet(){

        HeroLombok heroLombok = new HeroLombok();

        heroLombok.setName("Batman");

        Assertions.assertEquals("Batman", heroLombok.getName());
    }
}