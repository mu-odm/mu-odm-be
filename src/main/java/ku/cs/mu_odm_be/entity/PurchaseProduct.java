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

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productsId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("purchaseId")
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;
}
