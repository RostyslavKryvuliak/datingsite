package com.example.datingsite.repository;

import com.example.datingsite.entity.AdressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<AdressEntity, Long> {

    boolean existsById(Long id);


}
