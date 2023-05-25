package ua.ithillel.lesson31_spring_hero_MVC;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ithillel.lesson22.HeroDaoImpl;
import ua.ithillel.lesson31_spring_hero_MVC.exception.HeroMvcModelNotFound;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HeroMvcController {
    private final HeroDaoImpl heroDaoImpl;

    @GetMapping("/findAll")
    public String hero(Model model) {
        model.addAttribute("name", "Find all heroes!");
        model.addAttribute("heroes", heroDaoImpl.findAll());
        return "index";
    }

    @GetMapping("/findById/{id}")
    public String hero(Model model, @PathVariable("id") long id) {
        try {
            var hero = heroDaoImpl.findById(id);
            model.addAttribute("name", "Find hero dy id!");
            model.addAttribute("heroes", hero);
        } catch (RuntimeException e) {
            throw new HeroMvcModelNotFound("Hero with specified id does not exist");
        }
        return "index";
    }
}
