package com.spring.mySelectShop.domain.category.entity;

import com.spring.mySelectShop.domain.store.entity.StoreCategory;
import jakarta.persistence.CascadeType;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "category_id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_active", nullable = false)
    @ColumnDefault("true")
    private Boolean isActive = true;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<StoreCategory> storeCategories = new ArrayList<>();

    private Category(String name, Boolean isActive) {
        this.name = name;
        this.isActive = isActive != null ? isActive : Boolean.TRUE;
    }

    public static Category create(String name, Boolean isActive) {
        return new Category(name, isActive);
    }

    public void update(String name, Boolean isActive) {
        this.name = name;
        this.isActive = isActive != null ? isActive : this.isActive;
    }


}