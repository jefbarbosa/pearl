package com.jef.pearl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jef.pearl.entity.Jewel;
import com.jef.pearl.service.JewelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {


    @Autowired
    private JewelService jewelService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void insertJewelTest() throws Exception {
        Jewel jewel = new Jewel(1L, "Gold", 0.5, "quilates");

        MvcResult result = mockMvc.perform(post("/api/v1/joia/inserir")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(jewel)))
                .andExpect(status().isCreated())
                .andReturn();

        String response = result.getResponse().getContentAsString();

        assertEquals("Value Id: 1", response);
    }

}
