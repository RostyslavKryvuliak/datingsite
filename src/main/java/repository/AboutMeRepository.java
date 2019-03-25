package repository;

import entity.AboutMeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutMeRepository extends JpaRepository<AboutMeEntity, Long> {

    boolean existsById(Long id);

    boolean existsBywhyYouEnterIgnoreCase(String whyYouEnter);

}
