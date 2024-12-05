package kg.alatoo.database.dto.auth.response;

public record LoginResponse(
        String token,
        String refreshToken
) {
}