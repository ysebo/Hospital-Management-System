package kg.alatoo.database.service.impl;

import kg.alatoo.database.dto.auth.request.LoginRequest;
import kg.alatoo.database.dto.auth.request.RegisterRequest;
import kg.alatoo.database.dto.auth.response.LoginResponse;
import kg.alatoo.database.dto.auth.response.RegisterResponse;
import kg.alatoo.database.dto.user.UserDTO;
import kg.alatoo.database.entity.User;
import kg.alatoo.database.exception.CustomException;
import kg.alatoo.database.mapper.UserMapper;
import kg.alatoo.database.repository.UserRepository;
import kg.alatoo.database.service.AuthService;
import kg.alatoo.database.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Override
    public UserDTO register(RegisterRequest request) {
        if(userRepository.findByEmail(request.email()).isPresent()) {
            throw new CustomException("User with this email already exists!" , HttpStatus.BAD_REQUEST);
        }
        if(userRepository.findByPhoneNumber(request.phoneNumber()).isPresent()) {
            throw new CustomException("User with this phone number already exists!" , HttpStatus.BAD_REQUEST);
        }
        User user = mapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new CustomException("Error while saving user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return mapper.toDto(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new CustomException("User not found!", HttpStatus.NOT_FOUND));
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.email(),
                            request.password()
                    )
            );
        }catch (AuthenticationException e ){
            throw new CustomException("Invalid credentials!", HttpStatus.UNAUTHORIZED);
        }
        String token = jwtService.generateToken(user);
        return mapper.toLoginDtoToken(user, token);
    }
}
