package com.caito.sarmientolibrary.repository;

import com.caito.sarmientolibrary.entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long> {

    boolean existsByName(String name);
}
