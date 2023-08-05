package com.eng.onboarding.te.manager;

import com.eng.onboarding.te.Application;
import com.eng.onboarding.te.domain.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Application.class)
public class ShopManagerComponentTest {
    @Autowired
    private ShopManager shopManager;

    @Test
    public void createShopTest() {
        String name = "Shop1";
        String countryCode = "CountryCode1";
        Shop shop = shopManager.createShop(name, countryCode);
        assertNotNull(shop);
        assertNotNull(shop.getId());
        assertEquals(name, shop.getName());
        assertEquals(countryCode, shop.getCountryCode());
    }

    @Test
    public void getShopTest() throws ShopNotFoundException {
        String name = "Shop1";
        String countryCode = "CountryCode1";
        Shop shop = shopManager.createShop(name, countryCode);

        Shop persistedShop = shopManager.getShop(shop.getId());
        assertNotNull(persistedShop);
        assertEquals(shop.getId(), persistedShop.getId());
        assertEquals(name, persistedShop.getName());
        assertEquals(countryCode, persistedShop.getCountryCode());
    }
}