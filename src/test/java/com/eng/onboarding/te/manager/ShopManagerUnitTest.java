package com.eng.onboarding.te.manager;

import com.eng.onboarding.te.domain.Shop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class ShopManagerUnitTest {
    private ShopRepository shopRepository;
    private ShopManager shopManager;

    @BeforeEach
    public void beforeEach() {
        shopRepository = new ShopRepository();
        shopManager = new ShopManager(shopRepository);
    }

    @Test
    public void createShopTest() {
//        Mockito.when(shopRepository.save(any(Shop.class))).thenAnswer(invocation -> {
//            Shop shop = invocation.getArgument(0, Shop.class);
//            shop.setId(777L);
//            return shop;
//        });

        Shop shop = shopManager.createShop("Shop1", "CountryCode1");
        assertNotNull(shop);
        assertTrue(shop.getId()>0);
    }

    @Test
    public void getShopTest() throws ShopNotFoundException {
        // Write your code here
    }
}
