package ku.cs.mu_odm_be.response;

import ku.cs.mu_odm_be.entity.PPSKey;
import lombok.Data;

import java.util.UUID;

@Data
public class PPSResponse {
    private PPSKey id;
    private UUID product_id;
    private UUID product_size_id;
}
