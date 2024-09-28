package ku.cs.mu_odm_be.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@ToString
@Table(name = "product_size")
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String size;
    private double additional_price;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;
}
