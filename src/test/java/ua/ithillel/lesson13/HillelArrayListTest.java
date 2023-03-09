package ua.ithillel.lesson13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HillelArrayListTest {
    private HillelArrayList word;

    @BeforeEach
    void init() {
        word = new HillelArrayList();
    }

    @Test
    void addWordInArray1() {

        word.add("my");
        word.add("cinema");
        assertArrayEquals(word.getAll(), new String[]{"my", "cinema"});
    }

    @Test
    void removeWordFromArray1() {

        word.add("house1");
        word.add("house2");
        assertEquals("house1", word.remove(0));
        assertArrayEquals(word.getAll(), new String[]{"house2"});
    }

    @Test
    void removeWordFromArray2() {
        word.add("house1");
        assertEquals("house1", word.remove(0));
        assertArrayEquals(word.getAll(), new String[]{});
    }

    @Test
    void removeWordFromArray3() {
        word.add("garden");
        word.add("cinema");
        word.add("go");
        word.add("show");
        assertEquals("go", word.remove(2));
        assertArrayEquals(word.getAll(), new String[]{"garden", "cinema", "show"});
    }

    @Test
    void findConstainInArray1() {
        word.add("like");
        word.add("cinema");
        word.add("apple");
        word.add("mountain");
        word.add("town");
        assertEquals(false, word.contains("river"));
        assertEquals(false, word.contains("garden"));
        assertEquals(true, word.contains("mountain"));
    }

    @Test
    void findConstainInArray2() {
        word.add("like");
        word.add("cinema");
        word.add("apple");
        word.add("mountain");
        word.add("town");
        assertEquals(true, word.contains("like"));
    }

    @Test
    void findConstainInArray3() {
        word.add("like");
        word.add("cinema");
        word.add("apple");
        word.add("mountain");
        word.add("town");
        assertEquals(true, word.contains("apple"));
    }

    @Test
    void findIndexOfElement1() {
        word.add("house1");
        word.add("house2");
        word.add("flower");
        word.add("river");
        assertEquals(0, word.indexOf("house1"));
        assertEquals(-1, word.indexOf("par"));
        assertEquals(3, word.indexOf("river"));
    }

    @Test
    void findIndexOfElement2() {
        word.add("cat");
        word.add("house2");
        word.add("flower");
        word.add("look");
        assertEquals(1, word.indexOf("house2"));
        assertEquals(-1, word.indexOf("door"));
        assertEquals(0, word.indexOf("cat"));
    }

    @Test
    void findIndexOfElement3() {
        word.add("dog");
        word.add("house");
        word.add("city");
        word.add("wonderful");
        assertEquals(2, word.indexOf("city"));
        assertEquals(3, word.indexOf("wonderful"));
        assertEquals(-1, word.indexOf("live"));
    }

    @Test
    void getWord1() {
        word.add("like");
        word.add("ice");
        word.add("flower");
        word.add("mountain");
        word.add("river");
        assertEquals("like", word.get(0));
        assertEquals("mountain", word.get(3));
        assertEquals("ice", word.get(1));
    }

    @Test
    void getWord2() {
        word.add("like");
        word.add("ice");
        word.add("flower");
        word.add("mountain");
        word.add("river");
        assertEquals("flower", word.get(2));
    }

    @Test
    void getWord3() {
        word.add("like");
        word.add("ice");
        word.add("flower");
        word.add("mountain");
        word.add("river");
        assertEquals("river", word.get(4));
    }
}