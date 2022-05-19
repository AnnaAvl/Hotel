package com.service;

import com.entity.Promotion;

import java.util.List;

public interface PromotionService extends Service<Promotion> {
    List<Promotion> readByName(String name);
}
