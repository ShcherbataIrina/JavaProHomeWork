package ua.ithillel.lesson27_rest;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class HeroCreateRequest {
    String name;
    String race;
    String alignment;

}
