package com.mo.mobabmo.domain.category.controller;

import com.mo.mobabmo.domain.category.dto.FoodCategoryIdResponseDto;
import com.mo.mobabmo.domain.category.dto.FoodCategoryRequestDto;
import com.mo.mobabmo.domain.category.entity.FoodCategory;
import com.mo.mobabmo.domain.category.service.FoodCategoryService;
import com.mo.mobabmo.global.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class FoodCategoryController {
    private final FoodCategoryService categoryService;

    @PostMapping
    public ResponseEntity<CommonResponse<?>> createFoodCategory(
            @RequestBody FoodCategoryRequestDto requestDto){
        CommonResponse<FoodCategoryIdResponseDto> responseDto = categoryService.createFoodCategory(requestDto);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CommonResponse<?>> findFoodCategories(){
        CommonResponse<List<FoodCategory>> responseDto = categoryService.findFoodCategories();

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}