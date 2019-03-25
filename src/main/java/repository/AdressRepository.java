package repository;

import entity.AdressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<AdressEntity, Long> {

    boolean existsById(Long id);

    boolean existsByCityIgnoreCase(String city);

}
