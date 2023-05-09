package ua.ithillel.lesson23_patterns;

import ua.ithillel.lesson22.Hero;
import ua.ithillel.lesson22.HeroDao;

import java.util.List;

public class DummyHeroDao implements HeroDao {

    private final List<Hero> heroes;
    public DummyHeroDao(List<Hero> heroes) {
        this.heroes = heroes;
    }
    @Override
    public List<Hero> findAll() {
        return heroes;
    }

    @Override
    public List<Hero> findByName(String name) {
        return heroes.stream()
                .filter(hero -> hero.getName().equals(name))
                .toList();
    }

    @Override
    public Hero findById(Long id) {
        return heroes.stream()
                .filter(hero -> hero.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void create(Hero hero) {
        heroes.add(hero);
    }

    @Override
    public void update(Hero hero) {
        heroes.stream()
                .filter(heroes -> heroes.getName().equals(hero.getName()))
                .map(heroes -> hero)
                .toList();
    }

    @Override
    public boolean delete(Long id) {
        return heroes.stream()
                .filter(heroes -> heroes.getId() == (id))
                .toList().remove(id);

    }

}
