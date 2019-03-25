package repository;

import dto.UserDTO;
import entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

   boolean existsById(Long id);

   boolean existsByFirstnameIgnoreCase(String firstname);
}


