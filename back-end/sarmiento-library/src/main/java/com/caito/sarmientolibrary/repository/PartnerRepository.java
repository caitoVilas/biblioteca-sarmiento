package com.caito.sarmientolibrary.repository;

import com.caito.sarmientolibrary.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    boolean existsByDni(String dni);
    boolean existsByEmail(String email);
    Optional<Partner> findByDni(String dni);
    List<Partner> findByLastName(String lastName);
}
