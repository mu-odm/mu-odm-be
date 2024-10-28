package ku.cs.mu_odm_be.response;


import ku.cs.mu_odm_be.common.Region;
import lombok.Data;

import java.util.UUID;

@Data
public class UserResponse {
    private UUID id;
    private String email;
    private String username;
    private String role;
    private Region region;
}
