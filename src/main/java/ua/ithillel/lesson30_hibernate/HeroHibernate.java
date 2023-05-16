package ua.ithillel.lesson30_hibernate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "heroes")
public class HeroHibernate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String name;
    String gender;

    @Column(name = "eye_color")
    String eyeColor;
    String race;

    @Column(name = "hair_color")
    String hairColor;
    double height;

    @Column(name = "skin_color")
    String skinColor;
    String alignment;
    int weight;

    @Column(name = "publisher_id")
    Long publisherId;

}
