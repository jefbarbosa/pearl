package com.jef.pearl.service;

import com.jef.pearl.dto.JewelDTO;
import com.jef.pearl.entity.Jewel;
import com.jef.pearl.repository.JewelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelService {

    private JewelRepository jewelRepository;

    public JewelService(JewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }

    public Long insertJewel(Jewel jewel) {
        return jewelRepository.save(jewel).getId();
    }

    public List<Jewel> getAllJewels() {
        return jewelRepository.findAll();
    }

    public JewelDTO searchJewel(Long id) {
        Jewel jewel = findJewel(id);
        return JewelDTO.entityToDto(jewel);
    }

    private Jewel findJewel(Long id) {
        return jewelRepository.findById(id).orElse(new Jewel());
    }

    public String removeJewel(Long id) {
        Jewel jewel = findJewel(id);
        if (jewel.getId() == null) {
            return "Id not found!";
        }
        jewelRepository.delete(jewel);
        return "Jewel "+ id + " deleted";
    }

    public Jewel updateJewel(Long id, Jewel jewel) {
        Jewel jewelFound = findJewel(id);
        if (jewelFound.getId() == null) {
            return new Jewel();
        }
        jewel.setId(jewelFound.getId());
        jewelRepository.save(jewel);
        return jewel;
    }
}
