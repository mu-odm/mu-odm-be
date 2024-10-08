package ku.cs.mu_odm_be.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class PurchaseProductRequest {

    private UUID productId;

    @NotBlank
    private UUID purchaseId;

    @NotBlank
    private int amount;
}
