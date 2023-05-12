package ua.ithillel.lesson29_spring_core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.lesson22.HeroDaoImpl;
import ua.ithillel.lesson23_patterns.HeroService;

public class HeroMain {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(HeroConfiguration.class);
        var heroService = context.getBean(HeroService.class);
        var heroDao = context.getBean(HeroDaoImpl.class);

        System.out.println(heroDao.findByName("Hulk"));
        System.out.println(heroDao.findByName("Agent 13"));
        System.out.println(heroDao.findByName("King Kong"));

    }
}
