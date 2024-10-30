package ku.cs.mu_odm_be.request;

import jakarta.validation.constraints.NotBlank;
import ku.cs.mu_odm_be.common.Status;
import lombok.Data;

@Data
public class ProductRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String image;

    @NotBlank
    private double price;

    @NotBlank
    private Status status;

    @NotBlank
    private int remaining;


}
