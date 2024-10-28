package ku.cs.mu_odm_be.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class PPSKey implements Serializable {
    @Column(name = "product_id")
    private UUID product_id;

    @Column(name = "product_size_id")
    private UUID product_size_id;
}
