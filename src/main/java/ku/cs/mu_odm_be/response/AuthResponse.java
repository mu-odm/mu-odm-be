package ku.cs.mu_odm_be.response;

import lombok.Data;

@Data
public class AuthResponse {
    private String accessToken;
    private String tokenType;

    public AuthResponse(String accessToken) {
        this.accessToken = accessToken;
        this.tokenType = "Bearer";
    }
}
