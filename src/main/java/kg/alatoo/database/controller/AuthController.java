package kg.alatoo.database.controller;

import kg.alatoo.database.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {
    private AuthService authService;
}
