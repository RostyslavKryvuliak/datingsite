package com.example.datingsite.repository;

import com.example.datingsite.entity.AboutMeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutMeRepository extends JpaRepository<AboutMeEntity, Long> {

    boolean existsById(Long id);


}
