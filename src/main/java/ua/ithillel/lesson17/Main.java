package ua.ithillel.lesson17;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ua.ithillel.lesson17.HeroCSVFileRead.heroList;

public class Main {
    public static void main(String[] args) {

        String csvFilePath = "/heroes_information.csv";
        HeroCSVFileRead.load(csvFilePath);

        ListHero listHero = new ListHero(heroList);

        double avgHeight = listHero.averageHeight();
        System.out.println("\naverage height: " + avgHeight);

        String tallestHero = listHero.findTallest();
        System.out.println("the tallest: " + tallestHero);

        String weightiestHero = listHero.findWeightiest();
        System.out.println("the heaviest: "+ weightiestHero);

        Map<String, Long> countOfGenderGroup = listHero.countPersonsInEachGenderGroup();
        System.out.println("gender counts: " + countOfGenderGroup);

        Map<String, Long> countOfAlignment = listHero.countPersonInEachAlignment();
        System.out.println("alignment counts: " + countOfAlignment);

        List<String> topPublisher = listHero.findMostPopularPublisher();
        System.out.println("5 most popular publisher: " + topPublisher);

        List<String> topHairColor = listHero.top3HairColor();
        System.out.println("3 most popular hair color: " + topHairColor);

        String topEyeColor = listHero.mostPopularEyeColor();
        System.out.println("the most popular eye color: " + topEyeColor);

    }
}
