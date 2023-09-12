package com.eng.onboarding.te.manager;

import com.eng.onboarding.te.domain.Shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ShopRepository {

    private final Map<Long, Shop> inMemoryStorage = new HashMap<>();

    public Shop save(Shop shop) {
        Long newId = generateId();
        shop.setId(newId);
        inMemoryStorage.put(newId, shop);
        return shop;
    }

    public Shop findById(Long id) {
        return inMemoryStorage.get(id);
    }

    private Long generateId() {
        long id = Math.abs(new Random().nextLong());
        while (inMemoryStorage.containsKey(id)) {
            id = new Random().nextLong();
        }
        return id;
    }
}
