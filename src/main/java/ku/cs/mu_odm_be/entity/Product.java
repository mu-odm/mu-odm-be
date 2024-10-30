package ku.cs.mu_odm_be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ku.cs.mu_odm_be.common.Status;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@ToString
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private double price;

//    @JsonIgnore
//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//    private Set<PurchaseProduct> purchase_products = new HashSet<>();

    private Status status;
    private int remaining;

//    @JsonIgnore
//    @OneToMany(mappedBy = "product_id", fetch = FetchType.LAZY)
//    private Set<PPS> pps = new HashSet<>();
}
