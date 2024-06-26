package ru.magarusik.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.magarusik.client.controller.payload.NewUserPayload;
import ru.magarusik.client.security.ClientUserDetailService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final ClientUserDetailService clientUserDetailService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String getUsersPage(Model model) {
        model.addAttribute("users", this.clientUserDetailService.findAllUsers());
        return "/users/list";
    }

    @GetMapping("/create")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String createUserPage(Model model, NewUserPayload newUserPayload) {
        model.addAttribute("userPayload", newUserPayload);
        return "/users/create";
    }


    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String createUser(NewUserPayload payload) {
        this.clientUserDetailService.createUser(payload);
        return "redirect:/users";
    }

    @PutMapping("/edit")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String editUserPage() {
        return "/users/edit";
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String getUserPage(Model model, @PathVariable("username") String username) {
        var user = clientUserDetailService.findUserByUsername(username);
        model.addAttribute("user", user);
        return "/users/show-user";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String accessDenied() {
        return "errors";
    }
}
