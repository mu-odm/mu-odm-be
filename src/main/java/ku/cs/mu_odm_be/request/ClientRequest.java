package ku.cs.mu_odm_be.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.UUID;

@Data
public class ClientRequest {

    @NotBlank
    private String name;
    @NotBlank
    private UUID salesman_id;
    @NotBlank
    @Positive
    private int contract_year;

}
