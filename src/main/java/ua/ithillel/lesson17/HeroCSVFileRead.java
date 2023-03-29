package ua.ithillel.lesson17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HeroCSVFileRead {
    static List<Hero> heroList = new ArrayList<>();

    public static void read(String csvFilePath) {
        String delimiter = ";";
        String line = "";
        try {
            File file = new File(csvFilePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine();

                while ((line = bufferedReader.readLine()) != null) {
                    String[] valueField = line.split(delimiter);
                    try {
                        Hero hero = new Hero(valueField[0], valueField[1], valueField[2], valueField[3], valueField[4], Double.parseDouble(valueField[5]), valueField[6], valueField[7], valueField[8], Integer.parseInt(valueField[9]));
                        heroList.add(hero);
                    } catch (NullPointerException | NumberFormatException e) {
                        throw new RuntimeException("Error by add weight or height field !");
                    }
                }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Hero hero : heroList) {
            System.out.println(hero.name() + ", " + hero.gender() + ", " + hero.eyeColor() + ", " + hero.race() + ", " + hero.hairColor() + ", " + hero.height() + ", " + hero.publisher() + ", " + hero.skinColor() + ", " + hero.alignment() + ", " + hero.weight());
        }
    }

}
