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



@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    CarRepository carRepository;

    CarService carService;

    @Before
    public void setUp() throws Exception {
        carService = new CarService(carRepository);
    }


    @Test
    public void getAllCarsTest() throws Exception {
        List<Car> carList  = new ArrayList<>();
        carList.add(new Car(1L, "car1", "model1", 45000));
        carList.add(new Car(2L, "car2", "model2", 60000));
        carList.add(new Car(3L, "car3", "model3", 20000));

        when(carRepository.findAll()).thenReturn(carList);

        List<Car>allCars = carService.findAllCars();

        assertThat(allCars.size(), is(3));



    @Test
    public void getCarByBrandTest() {
        Car c1 = new Car(1L, "car1", "model1", 45000);
        when(carRepository.findByBrand(anyString())).thenReturn(c1);
        Car car = carService.findCarByBrand("car1");
        assertEquals("car1", car.getBrand());

        }
    }

    @Test
    public void getCarByModelTest() {
        Car c1 = new Car(1L, "car1", "model1", 45000);
        when(carRepository.findByModel(anyString())).thenReturn(c1);
        Car car = carService.findCarByModel("model1");
        assertEquals("model1", car.getModel());
    }
}


/* Category c1 =new Category(1L,"fruits", "/api/categories/fruits");
        when(categoryRepository.findByName(anyString())).thenReturn(c1);
        Category fruits = categoryService.findCategoryByName("fruits");
        assertEquals("fruits",fruits.getName());
        assertEquals("/api/categories/fruits", fruits.getUrl());
 */