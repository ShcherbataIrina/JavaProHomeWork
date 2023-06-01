package ua.ithillel.bank.person;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "persons")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person extends BaseEntity {

    private String uid;
    private String name;
    private String email;

}
