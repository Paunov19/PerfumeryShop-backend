package com.perfumery.perfumerywebapp.bootstrap;

import com.perfumery.perfumerywebapp.models.Perfume;

public class ParsedPerfumeMapper {
    public static Perfume toPerfume(ParsedPerfume parsedPerfume) {
        Perfume perfume = new Perfume();

        perfume.setName(parsedPerfume.getName());
       // perfume.setSize(parsedPerfume.getSize());
        //perfume.setDough(parsedPerfume.getDough());
        perfume.setPrice(parsedPerfume.getPrice());
        perfume.setProducts(parsedPerfume.getProducts());
        perfume.setImageUrl(parsedPerfume.getImageUrl());
        perfume.setQuantity(parsedPerfume.getQuantity());
        perfume.setIsAvailable(parsedPerfume.getIsAvailable());

        return perfume;
    }
}
