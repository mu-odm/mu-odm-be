package ku.cs.mu_odm_be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "purchase_products")
public class PurchaseProduct {
    @EmbeddedId
    private PurchaseProductKey id;

    private int amount;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("product_id")
//    @JoinColumn(name = "product_id", insertable = false, updatable = false)
//    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("purchase_id")
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pps_id")
//    @JoinColumn(name = "pps_id")
    private PPS pps;
}
