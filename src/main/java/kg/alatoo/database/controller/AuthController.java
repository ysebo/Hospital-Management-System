package kg.alatoo.database.controller;

import kg.alatoo.database.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/auth")
public class AuthController {
    private AuthService authService;
}
