package com.eng.onboarding.te.manager;

import com.eng.onboarding.te.Application;
import com.eng.onboarding.te.domain.Coordinate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Application.class)
public class ShopManagerIntegrationTest {
    @Autowired
    private ShopManager shopManager;

    @Test
    public void getCoordinateTest() throws URISyntaxException, IOException, InterruptedException, ShopNotFoundException {
        Coordinate coordinate = shopManager.getCoordinate(609L);
        assertNotNull(coordinate);
    }
}
