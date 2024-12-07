package kg.alatoo.database.dto.auth.response;

import lombok.Data;

@Data
public class RegisterResponse {

    private String email;
    private String fullName;

    public RegisterResponse(String email, String fullName) {
        this.email = email;
        this.fullName = fullName;
    }

    public RegisterResponse() {
        this.email = "";
        this.fullName = "";
    }
}
