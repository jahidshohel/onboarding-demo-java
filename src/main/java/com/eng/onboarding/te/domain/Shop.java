package com.eng.onboarding.te.domain;

//https://raw.githubusercontent.com/Ephigenia/ikea-availability-checker/main/src/data/stores.json
public class Shop {
    private Long id;
    private final String name;
    private final String countryCode;

    public Shop(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
