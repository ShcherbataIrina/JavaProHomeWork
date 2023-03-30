package ua.ithillel.lesson18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroBuilderTest {
    @Test
    void shouldGetName() {
        HeroBuilder heroBuilder = new HeroBuilder("Superman", "Male", "Blue", "-",
                "Black", 196.8, "Comics CMD", "-", "good", 80);

        assertEquals("Superman", heroBuilder.name);
    }
}