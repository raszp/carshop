package com.example.carshop.controller;

import com.example.carshop.model.Car;
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
    public void carsList() throws Exception{
        Car c1 = new Car();
        Car c2 = new Car();
        List<Car> carList = new ArrayList<>();
        carList.add(c1);
        carList.add(c2);

        when(carService.findAllCars()).thenReturn(carList);

        mockMvc.perform(get("/api/cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3) ));
    }

    @Test
    public void carByBrand() throws Exception {
        Car c1 = new Car(1L, "car1", "model1", 1000);
        when(carService.findCarByBrand(anyString())).thenReturn(c1);
        mockMvc.perform(get("/api/cars/brand"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand", equalTo(c1.getBrand())))
                .andExpect(jsonPath("$.model", equalTo(c1.getModel())))
                .andExpect(jsonPath("$.price", equalTo(c1.getPrice())));

    }

    @Test
    public void carByModel() throws Exception {
        Car car = new Car(1L, "Car1", "Model 1", 2000);
        when(carService.findCarByModel(anyString())).thenReturn(car);
        mockMvc.perform(get("api/cars/brand/model"))
                .andExpect(jsonPath("$.model", equalTo(car.getModel())));
    }
}