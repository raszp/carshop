package com.example.carshop.controller;


import com.example.carshop.model.Car;
import com.example.carshop.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    CarService carService;

    @Autowired

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<Car> carsList (){
        return carService.findAllCars();
    }

    @GetMapping("cars/{brand}")
    public Car carByBrand (String brand){
        return carService.findCarByBrand(brand);
    }

    @GetMapping("cars/{model}")
    public Car carByModel (String model){
        return carService.findCarByModel(model);
    }
}
