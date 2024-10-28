package ku.cs.mu_odm_be.repository;

import ku.cs.mu_odm_be.entity.PPS;
import ku.cs.mu_odm_be.entity.PPSKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PPSRepository extends JpaRepository<PPS, PPSKey>{
}
