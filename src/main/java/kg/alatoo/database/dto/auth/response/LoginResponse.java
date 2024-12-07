package kg.alatoo.database.dto.auth.response;

public record LoginResponse(
        String email,
        String token,
        String role
) {
}