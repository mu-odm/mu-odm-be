package ku.cs.mu_odm_be.request;

import jakarta.validation.constraints.NotBlank;
import ku.cs.mu_odm_be.common.PurchasApproval;
import lombok.Data;

@Data
public class PurchaseApprovalRequest {
    @NotBlank
    private PurchasApproval status;
}
