package com.spring.mySelectShop.domain.category.repository;

import com.spring.mySelectShop.domain.category.entity.Category;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    Page<Category> findAllByIsActiveTrue(Pageable pageable);
    Boolean existsByName(String name);
}
