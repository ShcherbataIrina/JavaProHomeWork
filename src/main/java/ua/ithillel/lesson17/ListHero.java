package ua.ithillel.lesson17;

import java.util.*;
import java.util.stream.Collectors;

public class ListHero {
    private final List<Hero> heroes;

    public ListHero(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public double averageHeight() {
        return heroes.stream()
                .filter(hero -> hero.height() > 0)
                .mapToDouble(Hero::height)
                .average()
                .orElse(0);
    }

    public String findTallest() {
        return heroes.stream()
                .max(Comparator.comparing(Hero::height))
                .map(Hero::name)
                .orElse("No heroes on the list!");
    }

    public String findWeightiest() {
        return heroes.stream()
                .max(Comparator.comparing(Hero::weight))
                .map(Hero::name)
                .orElse("No heroes on the list!");
    }

    public Map<String, Long> countPersonsInEachGenderGroup() {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::gender, Collectors.counting()));
    }

    public Map<String, Long> countPersonInEachAlignment() {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::alignment, Collectors.counting()));
    }

    public List<String> findMostPopularPublisher() {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::publisher, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> top3HairColor() {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::hairColor, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public String mostPopularEyeColor() {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::eyeColor, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("All heroes are bald !");

    }
}
