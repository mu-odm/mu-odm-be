package ku.cs.mu_odm_be.response;

import ku.cs.mu_odm_be.common.PurchasApproval;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class PurchaseResponse {
    private UUID id;
    private UUID clientID;
    private UUID orderID;
    private Timestamp created_at;
    private PurchasApproval status;
}
