package kg.alatoo.database.mapper;

import kg.alatoo.database.dto.auth.request.RegisterRequest;
import kg.alatoo.database.dto.auth.response.LoginResponse;
import kg.alatoo.database.dto.user.UserDTO;
import kg.alatoo.database.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
    LoginResponse toLoginResponseDTO(User user);
    default LoginResponse toLoginDtoToken(User user, String token) {
        LoginResponse loginResponse = toLoginResponseDTO(user);
        return new LoginResponse( loginResponse.email(), loginResponse.role(), token);
    }
    User toEntity(RegisterRequest request);
}
