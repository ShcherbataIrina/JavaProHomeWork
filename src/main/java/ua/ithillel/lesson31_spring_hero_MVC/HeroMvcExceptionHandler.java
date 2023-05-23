package ua.ithillel.lesson31_spring_hero_MVC;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.ithillel.lesson31_spring_hero_MVC.exception.HeroMvcModelNotFound;

@ControllerAdvice
public class HeroMvcExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerException(RuntimeException e) {
        return "error";
    }

    @ExceptionHandler(HeroMvcModelNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlerException(HeroMvcModelNotFound e, Model model) {
        model.addAttribute("message",e.getMessage());
        return "error";
    }
}
