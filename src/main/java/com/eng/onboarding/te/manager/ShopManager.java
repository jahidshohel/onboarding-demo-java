package com.eng.onboarding.te.manager;

import com.eng.onboarding.te.domain.Coordinate;
import com.eng.onboarding.te.domain.Shop;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ShopManager {
    private final ShopRepository shopRepository;

    public ShopManager(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop createShop(String name, String countryCode) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name can't be null or empty");
        }

        if (countryCode == null || countryCode.trim().length() == 0) {
            throw new IllegalArgumentException("Country code can't be null or empty");
        }

        Shop shop = new Shop(name, countryCode);
        shop = shopRepository.save(shop);
        return shop;
    }

    public Shop getShop(Long shopId) throws ShopNotFoundException {
        if (shopId <= 0) {
            throw new IllegalArgumentException("Invalid shop id");
        }

        Optional<Shop> optional = shopRepository.findById(shopId);
        if (optional.isEmpty()) {
            throw new ShopNotFoundException("No shop found with id: " + shopId);
        }
        return optional.get();
    }

    public Coordinate getCoordinate(Long shopId) throws URISyntaxException, IOException, InterruptedException, ShopNotFoundException {
        if (shopId <= 0) {
            throw new IllegalArgumentException("Invalid shop id");
        }
        return getRemoteCoordinate(shopId);
    }

    private Coordinate getRemoteCoordinate(Long shopId) throws URISyntaxException, IOException, InterruptedException, ShopNotFoundException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://raw.githubusercontent.com/Ephigenia/ikea-availability-checker/main/src/data/stores.json"))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        Map[] entries = mapper.readValue(response.body(), Map[].class);

        return Arrays.stream(entries)
                .filter(map -> map.get("buCode").equals(shopId.toString()))
                .map(map -> (List<Double>) map.get("coordinates"))
                .map(list -> new Coordinate(list.get(0), list.get(1)))
                .findFirst()
                .orElseThrow(() -> new ShopNotFoundException("No shop found with id: " + shopId));
    }
}
