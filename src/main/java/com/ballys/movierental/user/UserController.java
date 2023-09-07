package com.ballys.movierental.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @GetMapping
    public Collection<User> findUsers() {
        return userService.findUsers();
    }

    @PostMapping
    public void saveUser(@RequestBody @Valid User user) {
        userService.saveUser(user);
    }

}
