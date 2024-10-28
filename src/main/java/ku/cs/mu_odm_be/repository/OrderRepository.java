package ku.cs.mu_odm_be.repository;

import ku.cs.mu_odm_be.common.Region;
import ku.cs.mu_odm_be.common.Status;
import ku.cs.mu_odm_be.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    Order findByStatus(Status status);
    Order findByRegionAndStatus(Region region, Status status);
}
