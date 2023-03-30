package ua.ithillel.lesson18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroValueTest {
    @Test
    void shouldGetName() {

        HeroValue heroValue = new HeroValue("Harry Potter", "Male", "Green", "Human",
                "Brown", 173.5, "Comics CMD", "-", "good", 69);

        assertEquals("Harry Potter", heroValue.getName());
    }
}