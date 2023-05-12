package ua.ithillel.lesson23_patterns;

import ua.ithillel.lesson22.Hero;
import ua.ithillel.lesson22.HeroDao;
import ua.ithillel.lesson27_rest.HeroCreateRequest;

import java.util.List;
import java.util.stream.Collectors;

public class HeroService {
    private HeroDao heroDao;
    private HeroMovieService heroMovieService;

    protected HeroService(HeroDao heroDao, HeroMovieService heroMovieService) {
        this.heroDao = heroDao;
        this.heroMovieService = heroMovieService;

    }

    public List<HeroDto> getHeroes() {
        return heroDao.findAll()
                .stream()
                .map(hero -> new HeroDto(hero.getId(), hero.getName(), heroMovieService.getPlayedIn(hero.getName())))
                .collect(Collectors.toList());
    }

    public Hero create(HeroCreateRequest request) {
        var hero = Hero.builder()
                .name(request.getName())
                .gender("Man")
                .eyeColor("Blue")
                .race(request.getRace())
                .hairColor("Brown")
                .height(188)
                .alignment(request.getAlignment())
                .weight(85)
                .publisherId(2L)
                .build();

        heroDao.create(hero);
        return hero;
    }

    public Hero update(long id, HeroCreateRequest request) {

        var hero = heroDao.findById(id);
        hero.setName(request.getName());
        hero.setRace(request.getRace());
        hero.setAlignment(request.getAlignment());

        heroDao.update(hero);
        return hero;
    }

    public void delete(long id) {
         heroDao.delete(id);
    }

}
