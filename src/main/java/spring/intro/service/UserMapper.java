package spring.intro.service;

import dto.UserResponseDto;
import org.springframework.stereotype.Component;
import spring.intro.model.User;

@Component
public class UserMapper {
    public UserResponseDto createDtoFromUser(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setId(user.getId());
        return dto;
    }
}
