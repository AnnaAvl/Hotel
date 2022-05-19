package com.controller;


import com.entity.Promotion;
import com.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/promotion")
public class PromotionController extends AbstractController<Promotion>{
    @Autowired
    private PromotionService service;

    @Override
    public PromotionService getService() {
        return service;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Promotion>> getPromotionByName(@PathVariable String name) {
        List<Promotion> promotions = service.readByName(name);
        if (promotions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(promotions, headers, HttpStatus.OK);
    }
}
