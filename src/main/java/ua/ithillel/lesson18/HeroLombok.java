package ua.ithillel.lesson18;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Data

public class HeroLombok {
    String name;
    String gender;
    String eyeColor;
    String race;
    String hairColor;
    double height;
    String publisher;
    String skinColor;
    String alignment;
    int weight;
}

