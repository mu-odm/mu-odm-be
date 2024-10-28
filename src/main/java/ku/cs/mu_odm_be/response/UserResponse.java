package ku.cs.mu_odm_be.response;


import ku.cs.mu_odm_be.common.Region;
import lombok.Data;

@Data
public class UserResponse {
    private String email;
    private String username;
    private String role;
    private Region region;
}
