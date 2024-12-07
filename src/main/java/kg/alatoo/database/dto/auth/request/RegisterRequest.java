package kg.alatoo.database.dto.auth.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegisterRequest {

        @Email(message = "Email should be valid")
        @NotEmpty(message = "Email should be not empty")
        private String email;

        @NotEmpty(message = "Phone number should be not empty")
        private String phoneNumber;

        @NotEmpty(message = "Password should be not empty")
        private String password;

        public RegisterRequest() {
                this.email = "";
                this.phoneNumber = "";
                this.password = "";
        }

        public RegisterRequest(String email, String phoneNumber, String password) {
                this.email = email;
                this.phoneNumber = phoneNumber;
                this.password = password;
        }
}
