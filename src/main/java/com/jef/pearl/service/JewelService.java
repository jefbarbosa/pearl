package com.jef.pearl.service;

import com.jef.pearl.entity.Jewel;
import com.jef.pearl.repository.JewelRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    private Jewel searchJewel(Long id) {
        return jewelRepository.findById(id).orElse(new Jewel());
    }

    public String removeJewel(Long id) {
        Jewel jewel = searchJewel(id);
        if (jewel.getId() == null) {
            return "Id not found!";
        }
        jewelRepository.delete(jewel);
        return "Jewel "+ id + " deleted";
    }
}
