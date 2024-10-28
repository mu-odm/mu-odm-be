package ku.cs.mu_odm_be.repository;

import ku.cs.mu_odm_be.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findByid(UUID id);
    List<Product> findByName(String name);
}
