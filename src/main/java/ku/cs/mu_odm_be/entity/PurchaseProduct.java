package ku.cs.mu_odm_be.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "purchase_products")
public class PurchaseProduct {
    @EmbeddedId
    private PurchaseProductKey id;

    private int amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("purchase_id")
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pps_id")
    @JoinColumns({
            @JoinColumn(name = "pps_product_id", referencedColumnName = "product_id"),
            @JoinColumn(name = "pps_product_size_id", referencedColumnName = "product_size_id")
    })
    private PPS pps;
    private UUID clientID;
}
