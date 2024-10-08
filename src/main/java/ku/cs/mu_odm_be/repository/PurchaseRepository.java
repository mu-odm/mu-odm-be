package ku.cs.mu_odm_be.repository;

import ku.cs.mu_odm_be.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {
    Purchase findByClientId(UUID clientId);
}
