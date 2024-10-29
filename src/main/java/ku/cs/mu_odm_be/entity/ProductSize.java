package ku.cs.mu_odm_be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@ToString
@Table(name = "product_sizes")
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String size;
    private double additional_price;

    @JsonIgnore
    @OneToMany(mappedBy = "product_size", fetch = FetchType.LAZY)
    private Set<PPS> pps = new HashSet<>();
}
