package kg.alatoo.database.dto.auth.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(
        @NotEmpty(message = "Username should be not empty")
        String email,
        @NotEmpty(message = "Password should be not empty")
        String password
) {
        public LoginRequest() {
                this("", "");
        }
}