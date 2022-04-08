package com.jef.pearl.service;


import com.jef.pearl.entity.Customer;
import com.jef.pearl.entity.Jewel;
import com.jef.pearl.repository.JewelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JewelServiceTest {

    @Mock
    private JewelRepository jewelRepository;

    private JewelService jewelService;

    @BeforeEach
    private void initConfig() {
        MockitoAnnotations.openMocks(this);
        this.jewelService = new JewelService(jewelRepository);

    }

    @Test
    void getAllJewelsTest() {
        Customer customer = new Customer();
        List<Jewel> jewelList = Arrays.asList(new Jewel(1L, "Gold", 0.5, "quilates", customer),
                new Jewel(2L,"Silver", 0.32, "kg", customer));
        Mockito.when(jewelRepository.findAll()).thenReturn(jewelList);

        List<Jewel> returnList = jewelService.getAllJewels();

        assertEquals("Silver", returnList.get(1).getMaterial());
    }
}
