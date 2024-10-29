package ku.cs.mu_odm_be.response;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductSizeResponse {
    private UUID id;
    private String size;
    private double additional_price;
}
