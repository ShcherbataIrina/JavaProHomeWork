package ua.ithillel.lesson23_patterns;

import lombok.Data;

import java.util.List;

@Data
public class HeroDto {
    private long id;

    private String name;
    private List<String> movies;

    public HeroDto(long id, String name, List<String> movies) {
        this.id = id;
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

}
