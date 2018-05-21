package com.example.carshop.repository;


import com.example.carshop.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository <Car, Long>{

    Car findCarByBrand (String brand);


}
