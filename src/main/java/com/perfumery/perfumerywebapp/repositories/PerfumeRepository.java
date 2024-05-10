package com.perfumery.perfumerywebapp.repositories;

import com.perfumery.perfumerywebapp.models.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfumeRepository extends JpaRepository<Perfume, Long> {

    Perfume findPerfumeById(Long id);

    void deletePerfumeById(Long id);
//    List<Perfume> findAllById(Set<Long> productIds);
}
