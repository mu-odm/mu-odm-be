package ku.cs.mu_odm_be.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductSizeRequest {
    @NotBlank
    private String size;

    @NotBlank
    private double additional_price;

    @NotBlank
    private UUID product_id;
}
