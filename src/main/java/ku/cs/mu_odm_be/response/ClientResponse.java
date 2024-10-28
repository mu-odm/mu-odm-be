package ku.cs.mu_odm_be.response;

import lombok.Data;

import java.util.UUID;

@Data
public class ClientResponse {
    private UUID id;
    private String email;
    private String name;
    private int contract_year;
    private String location;
    private String contact;
    private boolean isDeferStatus;

    private UUID user_id;
}
