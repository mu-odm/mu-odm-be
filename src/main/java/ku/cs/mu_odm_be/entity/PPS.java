package ku.cs.mu_odm_be.entity;

import jakarta.persistence.*;
import ku.cs.mu_odm_be.common.Status;
import lombok.Data;

@Entity
@Data
@Table(name = "pps")
public class PPS {
    @EmbeddedId
    private PPSKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("product_size_id")
    @JoinColumn(name = "product_size_id")
    private ProductSize product_size;

    private int remaining;
    private Status status;

}
