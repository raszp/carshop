package com.example.carshop.bootstrap;


import com.example.carshop.model.Car;
import com.example.carshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner  {

    CarRepository carRepository;


    @Override
    public void run(String... args) throws Exception {
        loadCars();
    }

    private void loadCars() {
        Car c1 = new Car();
        Car c2 = new Car();
        c1.setBrand("Car 1");
        c1.setModel("Model 1");
        c2.setBrand("Car 2");
        c2.setBrand("Model 2");
        carRepository.save(c1);
        carRepository.save(c2);
    }
}
