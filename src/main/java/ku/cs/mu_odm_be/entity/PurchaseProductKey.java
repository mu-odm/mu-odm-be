package ku.cs.mu_odm_be.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import java.io.Serializable;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable

public class PurchaseProductKey implements Serializable {
    @Column(name = "purchase_id")
    private UUID purchaseId;

    @Column(name = "products_id")
    private UUID productsId;
}
