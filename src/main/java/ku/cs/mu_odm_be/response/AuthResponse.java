package ku.cs.mu_odm_be.response;

import ku.cs.mu_odm_be.entity.User;
import lombok.Data;

@Data
public class AuthResponse {
    private String accessToken;
    private String tokenType;
    private User user;

    public AuthResponse(String accessToken, User user) {
        this.accessToken = accessToken;
        this.tokenType = "Bearer";
        this.user = user;
    }
}
