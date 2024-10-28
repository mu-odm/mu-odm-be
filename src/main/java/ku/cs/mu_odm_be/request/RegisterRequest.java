package ku.cs.mu_odm_be.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import ku.cs.mu_odm_be.common.Region;
import ku.cs.mu_odm_be.validation.ValidPassword;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String username;
    @NotBlank
    @ValidPassword
    private String password;
    @NotBlank
    private Region region;
}
