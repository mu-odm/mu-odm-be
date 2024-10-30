package ku.cs.mu_odm_be.request;

import jakarta.validation.constraints.NotBlank;
import ku.cs.mu_odm_be.common.Status;
import lombok.Data;

import java.util.UUID;

@Data
public class PPSRequest {
    @NotBlank
    private UUID product_id;

    @NotBlank
    private UUID product_size_id;

    @NotBlank
    private int remaining;

    @NotBlank
    private Status status;

}
