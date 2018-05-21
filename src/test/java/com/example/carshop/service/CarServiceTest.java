package com.example.carshop.service;

import com.example.carshop.model.Car;
import com.example.carshop.repository.CarRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;



public class CarServiceTest {


}


/* Category c1 =new Category(1L,"fruits", "/api/categories/fruits");
        when(categoryRepository.findByName(anyString())).thenReturn(c1);
        Category fruits = categoryService.findCategoryByName("fruits");
        assertEquals("fruits",fruits.getName());
        assertEquals("/api/categories/fruits", fruits.getUrl());
 */