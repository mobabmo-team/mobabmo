package com.mo.mobabmo.domain.category.service;

import com.mo.mobabmo.domain.category.dto.FoodCategoryIdResponseDto;
import com.mo.mobabmo.domain.category.dto.FoodCategoryRequestDto;
import com.mo.mobabmo.domain.category.entity.FoodCategory;
import com.mo.mobabmo.domain.category.repository.FoodCategoryRepository;
import com.mo.mobabmo.global.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryService {
    private final FoodCategoryRepository foodCategoryRepository;

    /**
     * 음식 카테고리를 생성합니다.
     * @param requestDto 음식카테고리 생성 요청 dto
     * @return 음식카테고리식별자 응답 dto
     */
    public CommonResponse<FoodCategoryIdResponseDto> createFoodCategory(FoodCategoryRequestDto requestDto){

        String foodCategory = requestDto.getCategoryName();

        //생성할 음식 카테고리가 중복일 경우 예외 발생 -> 음식 카테고리 이름이 동일한 경우
        foodCategoryRepository.findByCategoryName(foodCategory).orElseThrow(
                () -> new IllegalArgumentException("이미 존재하는 음식 카테고리입니다.")
        );

        //새로운 음식 카테고리 저장 로직
        FoodCategory newFoodCategory = new FoodCategory(foodCategory);

        FoodCategory savedCategory = foodCategoryRepository.save(newFoodCategory);

        return new CommonResponse<>("카테고리 생성 완료",new FoodCategoryIdResponseDto(savedCategory.getId()));
    }

    /**
     *
     * @return
     */
    public CommonResponse<List<FoodCategory>> findFoodCategories(){
        List<FoodCategory> allFoodCategories = foodCategoryRepository.findAll();

        return new CommonResponse<>("모든 카테고리 조회 완료", allFoodCategories);
    }
}
