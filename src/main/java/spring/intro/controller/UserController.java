package spring.intro.controller;

import dto.UserResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.model.User;
import spring.intro.service.UserMapper;
import spring.intro.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/inject")
    public String inject() {
        User bob = new User();
        bob.setEmail("bob@gmail.com");
        bob.setPassword("bobpass");
        User alice = new User();
        alice.setEmail("alice@gmail.com");
        alice.setPassword("alicepass");
        User john = new User();
        john.setEmail("john@gmail.com");
        john.setPassword("johnpass");
        User dean = new User();
        dean.setEmail("dean@gmail.com");
        dean.setPassword("deanpass");
        userService.add(bob);
        userService.add(alice);
        return "All users were injected";
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable("userId") Long userId) {
        User user = userService.getById(userId);
        return userMapper.createDtoFromUser(user);
    }

    @GetMapping("/")
    List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
            .map(userMapper::createDtoFromUser)
            .collect(Collectors.toList());
    }
}
