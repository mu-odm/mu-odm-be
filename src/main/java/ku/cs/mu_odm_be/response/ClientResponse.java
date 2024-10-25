package ku.cs.mu_odm_be.response;

import lombok.Data;

import java.util.UUID;

@Data
public class ClientResponse {
    private UUID id;
    private String name;
    private int contract_year;
}
