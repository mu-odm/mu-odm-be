package ku.cs.mu_odm_be.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductRequest {
    @NotBlank
    private String name;

    @NotBlank
    private double price;

    @NotBlank
    private int available;
}
