package ua.ithillel.lesson23_patterns;

import java.util.List;
import java.util.Objects;

public class HeroDto {
    private String name;
    private List<String> movies;

    public HeroDto(String name, List<String> movies) {
        this.name = name;
        this.movies = movies;
    }
    public HeroDto() {
        this.name = name;
        this.movies = movies;
    }
    public static HeroDtoBuilder builder() {
        return new HeroDtoBuilder();
    }

    public String getName() {
        return name;
    }

    public List<String> getMovies() {
        return movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroDto heroDto = (HeroDto) o;
        return name.equals(heroDto.name) && movies.equals(heroDto.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, movies);
    }
}
