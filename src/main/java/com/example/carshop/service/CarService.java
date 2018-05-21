package com.example.carshop.service;


import com.example.carshop.model.Car;
import com.example.carshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CarService {

    CarRepository carRepository;

    @Autowired

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAllCars (){
        return carRepository.findAll();
    }

    public Car findByBrand (String brand){
        return carRepository.findCarByBrand(brand);
    }
}
