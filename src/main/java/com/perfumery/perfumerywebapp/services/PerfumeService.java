package com.perfumery.perfumerywebapp.services;

import com.perfumery.perfumerywebapp.dtos.PerfumeDTO;
import com.perfumery.perfumerywebapp.models.Perfume;

import java.util.List;

public interface PerfumeService {

    List<com.perfumery.perfumerywebapp.dtos.PerfumeDTO> getAllPerfumes();

    com.perfumery.perfumerywebapp.dtos.PerfumeDTO findPerfumeById(Long id);

    com.perfumery.perfumerywebapp.dtos.PerfumeDTO createPerfume(Perfume perfume);

    com.perfumery.perfumerywebapp.dtos.PerfumeDTO updatePerfume(Long id, Perfume perfume);

    void deletePerfume(Long id);
}