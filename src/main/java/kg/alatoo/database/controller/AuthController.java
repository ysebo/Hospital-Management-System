package kg.alatoo.database.controller;

import kg.alatoo.database.dto.auth.request.LoginRequest;
import kg.alatoo.database.dto.auth.request.RegisterRequest;
import kg.alatoo.database.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {
    private final AuthService authService;
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequest request) {
        authService.register(request);
        return "redirect:/pages/home";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest request) {
        authService.login(request);
        return "redirect:/pages/home";
    }
}
