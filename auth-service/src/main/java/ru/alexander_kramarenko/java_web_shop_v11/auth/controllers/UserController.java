package ru.alexander_kramarenko.java_web_shop_v11.auth.controllers;

import ru.alexander_kramarenko.java_web_shop_v11.api.dtos.ProfileDto;
import ru.alexander_kramarenko.java_web_shop_v11.api.exceptions.ResourceNotFoundException;
import ru.alexander_kramarenko.java_web_shop_v11.auth.model.User;
import ru.alexander_kramarenko.java_web_shop_v11.auth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
 //   @CrossOrigin("http://localhost:3000/market")
    @GetMapping("/me")
    public ProfileDto aboutCurrentUser(@RequestHeader String username) {
        User user = userService.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("Не удалось найти пользователя. Имя пользователя: " + username));
        return new ProfileDto(user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
