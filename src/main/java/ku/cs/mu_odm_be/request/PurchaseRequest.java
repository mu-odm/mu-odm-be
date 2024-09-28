package ku.cs.mu_odm_be.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class PurchaseRequest {
    @NotBlank
    private int status;

    @NotBlank
    private Timestamp created_at;

    @NotBlank
    private UUID client_id;

    @NotBlank
    private UUID order_id;
}
