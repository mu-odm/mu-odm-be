package ku.cs.mu_odm_be.request;

import jakarta.validation.constraints.NotBlank;
import ku.cs.mu_odm_be.entity.PPSKey;
import lombok.Data;

import java.util.UUID;

@Data
public class PurchaseProductRequest {

//    @NotBlank
//    private UUID productID;

    @NotBlank
    private UUID clientID;

    @NotBlank
    private int amount;

    @NotBlank
    private UUID product_id;

    @NotBlank
    private UUID product_size_id;

    @NotBlank
    private UUID purchase_id;
}
