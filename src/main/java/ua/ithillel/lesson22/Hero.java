package ua.ithillel.lesson22;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Hero {
    int id;
    String name;
    String gender;
    String eyeColor;
    String race;
    String hairColor;
    double height;
    String skinColor;
    String alignment;
    int weight;
    Long publisherId;
}
