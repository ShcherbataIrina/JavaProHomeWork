package ua.ithillel.lesson23_patterns;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeroMovieService {
    Map<String, List<String>> moviesHero = new HashMap<>();

    public List<String> getPlayedIn(String heroName) {
        //повертає будь який список фільмів в яких приймав участь герой.
        var result = moviesHero.containsKey(heroName);
        if (result == true) {
            return moviesHero.get(heroName);
        } else return Collections.emptyList();

    }
}
