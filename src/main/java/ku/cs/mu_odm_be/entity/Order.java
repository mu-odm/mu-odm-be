package ku.cs.mu_odm_be.entity;

import jakarta.persistence.*;
import ku.cs.mu_odm_be.common.Region;
import ku.cs.mu_odm_be.common.Status;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@ToString
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Purchase> purchases;

    private Status status;
    private Region region;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;
}