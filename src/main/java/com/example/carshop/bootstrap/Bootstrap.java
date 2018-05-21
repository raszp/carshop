package com.example.carshop.bootstrap;


import com.example.carshop.model.Car;
import com.example.carshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    CarRepository carRepository;

    @Autowired
    public Bootstrap(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCars();
    }

    private void loadCars() {
        Car c1 = new Car();
        c1.setBrand("Fiat");
        c1.setModel("Tipo");
        c1.setPrice(45000);
        Car c2 = new Car();
        c2.setBrand("Skoda");
        c2.setModel("Fabia");
        c2.setPrice(40000);
        Car c3 = new Car();
        c3.setBrand("BMW");
        c3.setModel("320");
        c3.setPrice(150000);

        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);

    }
}
