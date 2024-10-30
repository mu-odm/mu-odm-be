package ku.cs.mu_odm_be.repository;

import ku.cs.mu_odm_be.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {
    List<Purchase> findAllByClientId(UUID clientId);

    List<Purchase> findByOrderIdAndClientId(UUID orderId, UUID clientId);

    @Query("SELECT p FROM Purchase p WHERE p.client.id = :clientId AND p.id = :purchaseId")
    Optional<Purchase> findByClientIdAndPurchaseId(@Param("clientId") UUID clientId, @Param("purchaseId") UUID purchaseId);
}
