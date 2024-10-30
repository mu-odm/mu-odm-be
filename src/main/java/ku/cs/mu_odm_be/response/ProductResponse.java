package ku.cs.mu_odm_be.response;

import ku.cs.mu_odm_be.common.Status;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductResponse {
    private UUID id;
    private String name;
    private String image;
    private double price;
    private Status status;
    private int remaining;
}
