package com.jef.pearl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jef.pearl.entity.Jewel;
import com.jef.pearl.service.JewelService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntegrationTest {


    @Autowired
    private JewelService jewelService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    private MvcResult insertJewel(Jewel jewel) throws Exception {
        return mockMvc.perform(post("/api/v1/joia/inserir")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(jewel)))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    @Order(0)
    void insertJewelTest() throws Exception {
        Jewel jewel = new Jewel("Gold", 0.5, "quilates");

        MvcResult result = insertJewel(jewel);
        String response = result.getResponse().getContentAsString();

        assertEquals("1", response);
    }


    @Test
    @Order(1)
    void updateJewelTest() throws Exception {
        Jewel jewel = new Jewel("Gold", 0.77, "quilates");

        MvcResult resultInsert = insertJewel(jewel);
        String responseInsert = resultInsert.getResponse().getContentAsString();

        jewel.setMaterial("Silver");
        jewel.setWeight(1.55);

        MvcResult resultPut = mockMvc.perform(put("/api/v1/joia/atualizar")
                .contentType("application/json")
                .param("numero_identificacao", responseInsert)
                .content(objectMapper.writeValueAsString(jewel)))
                .andExpect(status().isCreated())
                .andReturn();

        String response = resultPut.getResponse().getContentAsString();
        Jewel returnedJewel = objectMapper.readValue(response, new TypeReference<Jewel>() {});

        assertAll(
                () -> assertEquals(jewel.getMaterial(), returnedJewel.getMaterial()),
                () -> assertNotEquals(0.77, jewel.getWeight())
        );
    }

}
