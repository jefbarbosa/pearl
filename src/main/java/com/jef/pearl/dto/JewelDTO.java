package com.jef.pearl.dto;

import com.jef.pearl.entity.Jewel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelDTO {

    private Long id;
    private String material;
    private double weight;
    private String weightUnit;

    public static Jewel dtoToEntity(JewelDTO jewelDTO) {
        return new Jewel(jewelDTO.getId(), jewelDTO.getMaterial(), jewelDTO.getWeight(), jewelDTO.getWeightUnit());
    }

    public static JewelDTO entityToDto(Jewel jewel) {
        return new JewelDTO(jewel.getId(), jewel.getMaterial(), jewel.getWeight(), jewel.getWeightUnit());
    }
}
