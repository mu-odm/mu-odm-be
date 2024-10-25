package ku.cs.mu_odm_be.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class ClientRequest {

    @NotBlank
    private String name;
    @NotBlank
    @Positive
    private int contract_year;

}
