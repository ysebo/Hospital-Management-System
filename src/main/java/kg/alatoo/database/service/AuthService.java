package kg.alatoo.database.service;

import kg.alatoo.database.dto.auth.request.LoginRequest;
import kg.alatoo.database.dto.auth.request.RegisterRequest;
import kg.alatoo.database.dto.auth.response.LoginResponse;
import kg.alatoo.database.dto.auth.response.RegisterResponse;
import kg.alatoo.database.dto.user.UserDTO;

public interface AuthService {
    UserDTO register(RegisterRequest request);

    LoginResponse login(LoginRequest request);
}
