package ku.cs.mu_odm_be.response;

import ku.cs.mu_odm_be.entity.PPSKey;
import ku.cs.mu_odm_be.entity.Product;
import ku.cs.mu_odm_be.entity.ProductSize;
import lombok.Data;

import java.util.UUID;

@Data
public class PPSResponse {
    private PPSKey id;
//    private UUID product_id;
//    private UUID product_size_id;
}
