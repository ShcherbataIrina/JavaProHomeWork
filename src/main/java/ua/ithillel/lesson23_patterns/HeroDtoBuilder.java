package ua.ithillel.lesson23_patterns;

import java.util.List;

public class HeroDtoBuilder {
    private String name;
    private List<String> movies;

    public HeroDtoBuilder name(String name) {
        this.name = name;
        return this;
    }

    public HeroDtoBuilder movies(List<String> movies) {
        this.movies = movies;
        return this;
    }

    public HeroDto build() {
        return new HeroDto(name, movies);
    }
}
