package ku.cs.mu_odm_be.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class ClientRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String name;
    @NotBlank
    @Positive
    private int contract_year;

    @NotBlank
    private String location;
    @NotBlank
    private String contact;

    @NotBlank
    private boolean isDeferStatus;

}
