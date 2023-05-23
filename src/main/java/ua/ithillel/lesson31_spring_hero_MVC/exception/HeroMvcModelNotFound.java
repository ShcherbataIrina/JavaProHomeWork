package ua.ithillel.lesson31_spring_hero_MVC.exception;

public class HeroMvcModelNotFound extends RuntimeException{
    public HeroMvcModelNotFound(String message) {
        super(message);
    }
}
