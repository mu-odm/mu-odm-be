package ku.cs.mu_odm_be.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@ToString
@Table(name = "salesmen")
public class Salesman {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String region;

    @OneToMany(mappedBy = "salesman")
    private List<Client> clients;

    @OneToOne(mappedBy = "salesman")
    private User user;
}
