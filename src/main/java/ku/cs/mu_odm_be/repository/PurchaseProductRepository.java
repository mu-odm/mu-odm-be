package ku.cs.mu_odm_be.repository;

import ku.cs.mu_odm_be.entity.PurchaseProduct;
import ku.cs.mu_odm_be.entity.PurchaseProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct, PurchaseProductKey>{
}
