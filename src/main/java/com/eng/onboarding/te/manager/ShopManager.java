package com.eng.onboarding.te.manager;

import com.eng.onboarding.te.domain.Shop;

public class ShopManager {
    private final ShopRepository shopRepository;

    public ShopManager(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop createShop(String name, String countryCode) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can't be null or empty");
        }

        if (countryCode == null || countryCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Country code can't be null or empty");
        }

        Shop shop = new Shop(name, countryCode);
        return shopRepository.save(shop);
    }

    public Shop getShop(Long shopId) throws ShopNotFoundException {
        if (shopId <= 0) {
            throw new IllegalArgumentException("Invalid shop id");
        }

        Shop shop = shopRepository.findById(shopId);
        if (shop == null) {
            throw new ShopNotFoundException("No shop found with id: " + shopId);
        }
        return shop;
    }
}
