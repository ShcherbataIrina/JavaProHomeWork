package ua.ithillel.lesson17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ListHeroTest {

    private List<Hero> heroList;
    private ListHero actualListHero;

    @BeforeEach
    void setUp() {
        heroList = new ArrayList<>();
        heroList.add(new Hero("Abraxas", "Male", "blue", "Cosmic Entity", "Black", -99, "Marvel Comics", "-", "bad", -99));
        heroList.add(new Hero("Adam Strange", "Male", "blue", "Human", "Blond", 185, "DC Comics", "-", "good", 88));
        heroList.add(new Hero("Elektra", "Female", "blue", "Human", "Black", 175, "Marvel Comics", "-", "good", 59));
        heroList.add(new Hero("Elle Bishop", "Female", "blue", "-", "Blond", -99, "NBC - Heroes", "-", "bad", -99));
        heroList.add(new Hero("Emma Frost", "Female", "green", "-", "Blond", 185, "DC Comics", "-", "good", 80));
        heroList.add(new Hero("Cecilia Reyes", "-", "brown", "-", "Brown", 170, "Marvel Comics", "-", "good", 62));
        heroList.add(new Hero("Gary Bell", "Male", "-", "Alpha", "-", -99, "SyFy", "-", "good", -99));
        heroList.add(new Hero("Harry Porter", "Male", "green", "Human", "Black", -99, "J. K. Rowling", "-", "good", -99));
        actualListHero = new ListHero(heroList);
    }

    @Test
    void shouldAverageHeight() {
        double averageHeight = actualListHero.averageHeight();
        List<Hero> testList = new ArrayList<>(heroList);
        double sumItem = 0;
        int count = 0;
        for (Hero item : testList) {
            if (item.height() > 0) {
                sumItem += item.height();
                count++;
            }
        }
        double expectedAverage = sumItem / count;

        assertEquals(expectedAverage, averageHeight);
    }

    @Test
    void shouldFindTallest() {
        String nameTallest = actualListHero.findTallest();
        List<Hero> testList = new ArrayList<>(heroList);
        double maxHeight = 0;
        String findName = "";
        for (Hero item : testList) {
            if (item.height() > maxHeight) {
                maxHeight = item.height();
                findName = item.name();
            }
        }
        System.out.println(findName);
        System.out.println(nameTallest);
        assertEquals(findName, nameTallest);
    }

    @Test
    void shouldFindWeightiest() {
        String nameWeightiest = actualListHero.findWeightiest();

        List<Hero> testList = new ArrayList<>(heroList);
        double maxWeight = 0;
        String findName = "";
        for (Hero item : testList) {
            if (item.weight() > maxWeight) {
                maxWeight = item.weight();
                findName = item.name();
            }
        }
        System.out.println(findName);
        System.out.println(nameWeightiest);
        assertEquals(findName, nameWeightiest);
    }

    @Test
    void shouldCountPersonsInEachGenderGroup() {
        Map<String, Long> expectMap = Map.of(
                "Male", 4L,
                "Female", 3L,
                "-", 1L);

        assertEquals(expectMap, actualListHero.countPersonsInEachGenderGroup());
    }

    @Test
    void shouldCountPersonInEachAlignment() {
        Map<String, Long> expectMap = Map.of(
                "bad", 2L,
                "good", 6L);

        assertEquals(expectMap, actualListHero.countPersonInEachAlignment());
    }


    @Test
    void shouldFindMostPopularPublisher() {
        List<String> expectNames = List.of("Marvel Comics", "DC Comics", "NBC - Heroes", "SyFy", "J. K. Rowling");
        assertEquals(expectNames, actualListHero.findMostPopularPublisher());
    }

    @Test
    void shouldTop3HairColor() {
        List<String> expectNames = List.of("Blond", "Black", "Brown");
        assertTrue(actualListHero.top3HairColor().size() == expectNames.size() && actualListHero.top3HairColor().containsAll(expectNames) && expectNames.containsAll(actualListHero.top3HairColor()));
    }

    @Test
    void shouldFindMostPopularEyeColor() {
        String expectEyeColor = "blue";
        assertEquals(expectEyeColor, actualListHero.mostPopularEyeColor());
    }

}