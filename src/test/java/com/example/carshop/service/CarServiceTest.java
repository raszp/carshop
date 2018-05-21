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
    public void findAllCarsTest() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car (1L, "car 1", "model 1"));
        carList.add(new Car(2L, "car2 ", "model 2"));

        when(carRepository.findAll()).thenReturn(carList);

        List<Car> allCars = carService.findAllCars();

        assertThat(allCars.size(), is(2));
    }

    @Test
    public void findByBrandTest() {
        Car c1 = new Car(1L, "Fiat", "Tipo");

        when(carRepository.findCarByBrand(anyString())).thenReturn(c1);

        Car car = carService.findByBrand("Fiat");

        assertEquals("Fiat", car.getBrand());
        assertEquals("Tipo", car.getModel());
    }
}