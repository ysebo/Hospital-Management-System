package kg.alatoo.database.dto.auth.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record RegisterRequest(
        @Email(message = "Email should be valid")
        @NotEmpty(message = "Email should be not empty")
        String email,
        @NotEmpty(message = "phoneNumber should be not empty")
        String phoneNumber,
        @NotEmpty(message = "Password should be not empty")
        String password
) {
}