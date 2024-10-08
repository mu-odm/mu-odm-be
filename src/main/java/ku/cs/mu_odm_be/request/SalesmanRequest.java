package ku.cs.mu_odm_be.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SalesmanRequest {
    @NotBlank
    private String region;
}
