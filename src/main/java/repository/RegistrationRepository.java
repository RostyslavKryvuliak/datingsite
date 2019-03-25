package repository;

import entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Long> {

    boolean existsById(Long id);

    boolean existsByPasswordIgnoreCase(String password);

}
