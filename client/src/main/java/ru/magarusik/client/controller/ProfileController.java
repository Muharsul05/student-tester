package ru.magarusik.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.magarusik.client.client.RestClientTesting;
import ru.magarusik.client.security.ClientUserDetailService;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ClientUserDetailService clientUserDetailService;
    private final RestClientTesting restClientTesting;

    @GetMapping
    public String getProfilePage(Model model, Authentication authentication) {
        var user = clientUserDetailService.findUserByUsername(authentication.getName());
        var userProfile = restClientTesting.getUserProfile(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("userProfile", userProfile);
        return "/user/profile";
    }

    @GetMapping("/{username}")
    public String getProfilePage(Model model, @PathVariable String username) {
        var user = clientUserDetailService.findUserByUsername(username);
        var userProfile = restClientTesting.getUserProfile(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("userProfile", userProfile);
        return "/user/profile";
    }
}
