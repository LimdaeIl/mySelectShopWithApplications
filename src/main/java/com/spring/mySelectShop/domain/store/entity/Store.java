package com.spring.mySelectShop.domain.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "store_id", unique = true, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "minimum_price", nullable = false)
    private Integer minimum_price;

    @Column(name = "delivery_price", nullable = false)
    private Integer delivery_price;

    @Column(name = "rating", nullable = false)
    private Float rating;

    @OneToMany(mappedBy = "store")
    private List<StoreCategory> storeCategories = new ArrayList<StoreCategory>();
}
