package com.eng.onboarding.te.manager;

import com.eng.onboarding.te.Application;
import com.eng.onboarding.te.domain.Shop;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = Application.class)
public class ShopManagerUnitTest {
    @MockBean
    private ShopRepository shopRepository;
    @Autowired
    private ShopManager shopManager;

    @Test
    public void createShopTest() {
        Mockito.when(shopRepository.save(any(Shop.class))).thenAnswer(invocation -> {
            Shop shop = invocation.getArgument(0, Shop.class);
            shop.setId(777l);
            return shop;
        });

        shopManager.createShop("Shop1", "CountryCode1");
        verify(shopRepository).save(any(Shop.class));
    }

    @Test
    public void getShopTest() throws ShopNotFoundException {
        // Write your code here
    }
}
