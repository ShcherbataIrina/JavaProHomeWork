package ua.ithillel.lesson17;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HeroCSVFileRead {
    static List<Hero> heroList = new ArrayList<>();

    public static void load(String csvFilePath) {
        String delimiter = ";";
        String line = "";
        try (var input = HeroCSVFileRead.class.getResourceAsStream(csvFilePath)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] valueField = line.split(delimiter);

                Hero hero = new Hero(valueField[1], valueField[2], valueField[3], valueField[4], valueField[5],
                        Double.parseDouble(valueField[6].replace(',', '.')), valueField[7],
                        valueField[8], valueField[9], Integer.parseInt(valueField[10]));
                heroList.add(hero);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Hero hero : heroList) {
            System.out.println(hero.name() + ", " + hero.gender() + ", " + hero.eyeColor() + ", " + hero.race() + ", " + hero.hairColor() + ", " + hero.height() + ", " + hero.publisher() + ", " + hero.skinColor() + ", " + hero.alignment() + ", " + hero.weight());
        }
    }

}
