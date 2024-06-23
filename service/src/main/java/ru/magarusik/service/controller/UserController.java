package ru.magarusik.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.magarusik.service.dto.UserProfileDTO;
import ru.magarusik.service.entity.UserProfile;
import ru.magarusik.service.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserProfileDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public UserProfile createUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
        return userService.createNewUserProfile(userProfileDTO);
    }

    @GetMapping("/{userId}")
    public UserProfileDTO getUserProfile(@PathVariable long userId) {
        return userService.getUserProfileByUserId(userId);
    }
}
