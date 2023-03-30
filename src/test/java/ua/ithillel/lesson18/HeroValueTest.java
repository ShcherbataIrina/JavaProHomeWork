package ua.ithillel.lesson18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class  HeroValueTest {
    @Test
    void shouldGetItemHeroValue() {

        HeroValue heroValue = new HeroValue("Harry Potter", "Male", "Green", "Human",
                "Brown", 173.5, "Comics CMD", "-", "good", 69);

        assertEquals("Harry Potter", heroValue.getName());
        assertEquals("Male", heroValue.getGender());
        assertEquals("good", heroValue.getAlignment());
        assertEquals("Human", heroValue.getRace());
        assertEquals("Comics CMD", heroValue.getPublisher());
        assertEquals("Green", heroValue.getEyeColor());
        assertEquals("Brown", heroValue.getHairColor());
        assertEquals("-", heroValue.getSkinColor());
        assertEquals(173.5, heroValue.getHeight());
        assertEquals(69, heroValue.getWeight());

    }
}