package ku.cs.mu_odm_be.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class PurchaseProductRequest {

    @NotBlank
    private UUID productID;

    @NotBlank
    private UUID clientID;

    @NotBlank
    private int amount;
}
