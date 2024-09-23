package ku.cs.mu_odm_be.repository;

import ku.cs.mu_odm_be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
   User findByEmail(String email);
   User findByUsername(String username);
   Boolean existsByEmail(String email);
}
