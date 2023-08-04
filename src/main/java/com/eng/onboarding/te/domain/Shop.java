package com.eng.onboarding.te.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

//https://raw.githubusercontent.com/Ephigenia/ikea-availability-checker/main/src/data/stores.json
@Data
@Entity
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String countryCode;

    public Shop(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public Shop(Long id, String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }
}
