package ku.cs.mu_odm_be.repository;

import ku.cs.mu_odm_be.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductSizeRepository extends JpaRepository<ProductSize, UUID> {
    ProductSize findByProductId(UUID productId);
}
