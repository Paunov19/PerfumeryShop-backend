package com.perfumery.perfumerywebapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PerfumeDTO {

    private Long id;
    private String name;
    private Double price;
    private String products;
    private String imageUrl;
    private Long quantity;
    private boolean isAvailable;

}
