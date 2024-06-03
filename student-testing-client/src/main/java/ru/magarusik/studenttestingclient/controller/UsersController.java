package ru.magarusik.studenttestingclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.magarusik.studenttestingclient.controller.payload.NewUserPayload;
import ru.magarusik.studenttestingclient.security.ClientUserDetailService;

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

    @GetMapping("/{username}")
    public String getTestPage(Model model, @PathVariable("username") String username) {
        model.addAttribute("test", clientUserDetailService.findUseByUsername(username));
        return "/tests/showTest";
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

    @ExceptionHandler(AccessDeniedException.class)
    public String accessDenied() {
        return "errors";
    }
}
