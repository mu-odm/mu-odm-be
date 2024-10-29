package ku.cs.mu_odm_be.repository;

import ku.cs.mu_odm_be.entity.PPS;
import ku.cs.mu_odm_be.entity.PPSKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PPSRepository extends JpaRepository<PPS, PPSKey>{
    List<PPS> findAllByProductID(UUID product_id);
}
