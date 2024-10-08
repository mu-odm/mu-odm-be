package ku.cs.mu_odm_be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.*;

@Entity
@Data
@ToString
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JsonIgnore
    @OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY)
    private List<PurchaseProduct> purchaseProducts = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clients_id", nullable = true)
    private Client client;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", nullable = true)
    private Order order;

    private String status;
    private Timestamp created_at;
}
