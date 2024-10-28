package ku.cs.mu_odm_be.response;

import ku.cs.mu_odm_be.common.Region;
import ku.cs.mu_odm_be.common.Status;
import lombok.Data;

import java.util.UUID;


@Data
public class OrderResponse {
    private UUID id;
    private Status status;
    private UserResponse user;
    private Region region;
}
