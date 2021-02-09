package spring.intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.model.User;
import spring.intro.service.UserService;

public class Main {

    public static void main(String[] args) {
        User bob = new User();
        bob.setEmail("bob@gmail.com");
        bob.setPassword("bobpass");
        User alice = new User();
        alice.setEmail("alice@gmail.com");
        alice.setPassword("alicepass");
        AnnotationConfigApplicationContext config =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = config.getBean(UserService.class);
        userService.add(bob);
        userService.add(alice);
        System.out.println(userService.listUsers());
    }
}
