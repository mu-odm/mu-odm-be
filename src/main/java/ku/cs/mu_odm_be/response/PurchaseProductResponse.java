package ku.cs.mu_odm_be.response;

import ku.cs.mu_odm_be.entity.PurchaseProductKey;
import lombok.Data;

import java.util.UUID;

@Data
public class PurchaseProductResponse {
    private PurchaseProductKey id;
    private UUID productID;
    private UUID clientID;
    private int amount;
}
