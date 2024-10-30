package ku.cs.mu_odm_be.response;

import ku.cs.mu_odm_be.common.Status;
import ku.cs.mu_odm_be.entity.PPSKey;
import ku.cs.mu_odm_be.entity.Product;
import ku.cs.mu_odm_be.entity.ProductSize;
import lombok.Data;

import java.util.UUID;

@Data
public class PPSResponse {
    private PPSKey id;
    private int remaining;
    private Status status;
}
