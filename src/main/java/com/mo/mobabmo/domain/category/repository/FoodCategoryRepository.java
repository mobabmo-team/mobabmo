package com.mo.mobabmo.domain.category.repository;

import com.mo.mobabmo.domain.category.entity.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
    //리포지토리에 음식 카테고리 이름으로 조회하는 함수 생성
    Optional<FoodCategory> findByCategoryName (String categoryName);
}
