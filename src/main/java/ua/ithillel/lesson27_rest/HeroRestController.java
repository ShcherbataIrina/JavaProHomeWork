package ua.ithillel.lesson27_rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.lesson22.Hero;
import ua.ithillel.lesson22.HeroDao;
import ua.ithillel.lesson23_patterns.HeroService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HeroRestController {
    private final HeroService heroService;
    private final HeroDao dao;
/*
    @GetMapping("/heroes")
    public List<HeroDto> getAllHeroes() {
        return heroService.getHeroes();
    }

   @GetMapping("/heroes/{id}")
    public HeroDto getHeroById(@PathVariable("id") long id){
        return heroService.getHeroes()
                .stream()
                .filter(hero -> hero.getId()==id)
                .findFirst()
                .orElse(null);
    }
*/

    @GetMapping("/heroes")
    public List<Hero> getAllHeroes() {
        return dao.findAll();
    }

    @GetMapping("/heroes/{id}")
    public Hero getHeroById(@PathVariable("id") long id) {
        return dao.findById(id);
    }

    @PostMapping("/heroes")
    public Hero createHero(@RequestBody HeroCreateRequest request) {

        return heroService.create(request);
    }

    @PutMapping("/heroes/{id}")
    public Hero updateHero(@PathVariable("id") long id, @RequestBody HeroCreateRequest request) {

        return heroService.update(id, request);
    }

    @DeleteMapping("/heroes/{id}")
    public ResponseEntity deleteHero(@PathVariable("id") long id) {

        heroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
