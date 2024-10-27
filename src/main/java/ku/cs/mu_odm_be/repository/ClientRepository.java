package ku.cs.mu_odm_be.repository;

import ku.cs.mu_odm_be.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    Client findByEmail(String email);
    Boolean existsByEmail(String email);
}
