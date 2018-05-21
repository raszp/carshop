package com.example.carshop.controller;

import com.example.carshop.model.Car;
import com.example.carshop.repository.CarRepository;
import com.example.carshop.service.CarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
public class CarControllerTest {

    @Mock
    CarService carService;

    @InjectMocks
    CarController carController;

    MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
    public void carList() throws Exception {
        Car c1 = new Car(1L, "car 1", "model 1");
        Car c2 = new Car(2L, "car2", "model 2");
        List<Car> allCars = new ArrayList<>();
        allCars.add(c1);
        allCars.add(c2);

        when(carService.findAllCars()).thenReturn(allCars);

        mockMvc.perform(get("/api/cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));

    }

    @Test
    public void carByBrand() throws Exception {
        Car c1 = new Car(1L, "car 1", "model 1");

        when(carService.findByBrand(anyString())).thenReturn(c1);

        mockMvc.perform(get("/api/cars/brand"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand", equalTo("car 1")))
                .andExpect(jsonPath("$.model", equalTo("model 1")));

    }
}