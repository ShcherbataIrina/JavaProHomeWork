package ua.ithillel.lesson30_hibernate;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(HeroConfig.class);
        var sessionFactory = context.getBean(SessionFactory.class);

        try (var session = sessionFactory.openSession()) {
            var hero = session.find(HeroHibernate.class, 100);
            System.out.println(hero);

        }
    }
}
