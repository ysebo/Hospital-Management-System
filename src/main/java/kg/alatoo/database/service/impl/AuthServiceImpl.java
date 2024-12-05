package kg.alatoo.database.service.impl;

import kg.alatoo.database.dto.auth.request.LoginRequest;
import kg.alatoo.database.dto.auth.request.RegisterRequest;
import kg.alatoo.database.dto.auth.response.LoginResponse;
import kg.alatoo.database.dto.auth.response.RegisterResponse;
import kg.alatoo.database.repository.UserRepository;
import kg.alatoo.database.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    @Override
    public RegisterResponse register(RegisterRequest request) {
        return null;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }
}
