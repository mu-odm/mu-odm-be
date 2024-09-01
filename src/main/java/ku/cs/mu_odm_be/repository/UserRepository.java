package ku.cs.mu_odm_be.repository;

import ku.cs.mu_odm_be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Provided: basic CRUD operations (query methods)

    User findByEmail(String email);
}
