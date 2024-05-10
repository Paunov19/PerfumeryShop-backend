package com.perfumery.perfumerywebapp.services.impl;

import com.perfumery.perfumerywebapp.exceptions.PerfumeNotFoundException;
import com.perfumery.perfumerywebapp.models.Perfume;
import com.perfumery.perfumerywebapp.repositories.PerfumeRepository;
import com.perfumery.perfumerywebapp.services.PerfumeService;
import com.perfumery.perfumerywebapp.utils.PerfumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PerfumeServiceImpl implements PerfumeService {

    @Autowired
    private PerfumeRepository perfumeRepository;

    @Override
    public List<com.perfumery.perfumerywebapp.dtos.PerfumeDTO> getAllPerfumes() {
        return perfumeRepository.findAll().stream()
                .map(PerfumeMapper::perfumeToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public com.perfumery.perfumerywebapp.dtos.PerfumeDTO findPerfumeById(Long id) {
        Optional<Perfume> perfume = perfumeRepository.findById(id);

        if(perfume.isEmpty()) {
            throw new PerfumeNotFoundException("Perfume with this id doesn't exist");
        }

        return perfume.map(PerfumeMapper::perfumeToDTO).orElse(null);
    }

    @Override
    public com.perfumery.perfumerywebapp.dtos.PerfumeDTO createPerfume(Perfume perfume) {
        return PerfumeMapper.perfumeToDTO(perfumeRepository.save(perfume));
    }

    @Override
    @Transactional
    public com.perfumery.perfumerywebapp.dtos.PerfumeDTO updatePerfume(Long id, Perfume perfume) {
        perfume.setId(id);

        return PerfumeMapper.perfumeToDTO(perfumeRepository.save(perfume));
    }

    @Override
    @Transactional
    public void deletePerfume(Long id) {
        perfumeRepository.deletePerfumeById(id);
    }
}
