package kg.alatoo.database.controller;

import kg.alatoo.database.dto.auth.request.LoginRequest;
import kg.alatoo.database.dto.auth.request.RegisterRequest;
import kg.alatoo.database.dto.auth.response.LoginResponse;
import kg.alatoo.database.dto.auth.response.RegisterResponse;
import kg.alatoo.database.dto.user.UserDTO;
import kg.alatoo.database.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {
    private AuthService authService;
    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequest request) {
        UserDTO response = authService.register(request);
        return "redirect:/pages/home";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest request) {
        LoginResponse response = authService.login(request);
        return "redirect:/pages/home";
    }
}
