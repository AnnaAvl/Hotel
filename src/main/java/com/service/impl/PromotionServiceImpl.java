package com.service.impl;

import com.entity.Promotion;
import com.repository.PromotionRepository;
import com.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    private PromotionRepository repository;

    @Override
    public Promotion read(long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Promotion> read() {
        return repository.findAll();
    }

    @Override
    public void save(Promotion entity) {
        repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Promotion entity) {
        Promotion promotion = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        promotion.setBookings(entity.getBookings());
        promotion.setDiscount(entity.getDiscount());
        promotion.setName(entity.getName());
        repository.save(promotion);
    }

    @Override
    public List<Promotion> readByName(String name) {
        return repository.findByName(name);
    }


}
