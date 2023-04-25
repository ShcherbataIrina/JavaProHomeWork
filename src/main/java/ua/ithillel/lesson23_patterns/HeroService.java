package ua.ithillel.lesson23_patterns;

import ua.ithillel.lesson22.HeroDao;

import java.util.List;
import java.util.stream.Collectors;

public class HeroService {
    private   HeroDao heroDao;
    private HeroMovieService heroMovieService;

    protected HeroService(HeroDao heroDao, HeroMovieService heroMovieService) {
        this.heroDao = heroDao;
        this.heroMovieService = heroMovieService;

    }

    public List<HeroDto> getHeroes() {
        return heroDao.findAll()
                .stream()
                .map(hero -> new HeroDto(hero.getName(), heroMovieService.getPlayedIn(hero.getName())))
                .collect(Collectors.toList());
    }
}
