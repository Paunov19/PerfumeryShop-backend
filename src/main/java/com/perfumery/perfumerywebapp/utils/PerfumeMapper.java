package com.perfumery.perfumerywebapp.utils;

import com.perfumery.perfumerywebapp.dtos.PerfumeDTO;
import com.perfumery.perfumerywebapp.models.Perfume;

public class PerfumeMapper {

    private PerfumeMapper() {

    }

    public static com.perfumery.perfumerywebapp.dtos.PerfumeDTO perfumeToDTO(Perfume perfume) {
        com.perfumery.perfumerywebapp.dtos.PerfumeDTO perfumeDTO = new com.perfumery.perfumerywebapp.dtos.PerfumeDTO();

        perfumeDTO.setId(perfume.getId());
        perfumeDTO.setName(perfume.getName());
        //perfumeDTO.setSize(perfume.getSize());
        perfumeDTO.setPrice(perfume.getPrice());
        perfumeDTO.setProducts(perfume.getProducts());
       // perfumeDTO.setDough(perfume.getDough());
        perfumeDTO.setImageUrl(perfume.getImageUrl());
        perfumeDTO.setQuantity(perfume.getQuantity());
        perfumeDTO.setAvailable(perfume.getIsAvailable());

        return perfumeDTO;
    }

    public static Perfume perfumeDTOToPerfume(PerfumeDTO perfumeDTO) {
        Perfume perfume = new Perfume();
        perfume.setId(perfumeDTO.getId());
        perfume.setName(perfumeDTO.getName());
        perfume.setProducts(perfumeDTO.getProducts());
        //perfume.setDough(perfumeDTO.getDough());
       // perfume.setSize(perfumeDTO.getSize());
        perfume.setImageUrl(perfumeDTO.getImageUrl());

        return perfume;
    }
}
