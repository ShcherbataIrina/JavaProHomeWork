package ua.ithillel.lesson17;

import java.util.Objects;

public record Hero(String name, // ім'я
                   String gender, // стать
                   String eyeColor, // колір очей
                   String race, // раса
                   String hairColor, // колір волосся
                   double height, // зріст
                   String publisher,  // видавець
                   String skinColor, // колір шкіри
                   String alignment, // добро / зло
                   int weight) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Double.compare(hero.height, height) == 0 && weight == hero.weight && name.equals(hero.name) && gender.equals(hero.gender) && eyeColor.equals(hero.eyeColor) && race.equals(hero.race) && hairColor.equals(hero.hairColor) && publisher.equals(hero.publisher) && skinColor.equals(hero.skinColor) && alignment.equals(hero.alignment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, eyeColor, race, hairColor, height, publisher, skinColor, alignment, weight);
    }

}
