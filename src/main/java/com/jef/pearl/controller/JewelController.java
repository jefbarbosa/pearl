package com.jef.pearl.controller;

import com.jef.pearl.entity.Jewel;
import com.jef.pearl.service.JewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/joia")
public class JewelController {

    @Autowired
    private JewelService jewelService;


    @PostMapping("/inserir")
    public ResponseEntity<Long> insertJewell(@RequestBody Jewel jewel) {
        return new ResponseEntity<>(jewelService.insertJewel(jewel), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Jewel>> getAllJewels() {
        return new ResponseEntity<>(jewelService.getAllJewels(), HttpStatus.OK);
    }

    @GetMapping("/excluir")
    public ResponseEntity<String> removeJewel(@RequestParam(name = "numero_identificacao") Long id) {
        return new ResponseEntity<>(jewelService.removeJewel(id), HttpStatus.OK);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Jewel> updateJewel(@RequestParam(name = "numero_identificacao") Long id,
                                              @RequestBody Jewel jewel) {
        return new ResponseEntity<>(jewelService.updateJewel(id, jewel), HttpStatus.CREATED);
    }
}
