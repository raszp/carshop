package com.example.carshop.repository;

import com.example.carshop.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository <Car, Long>{

    Car findByBrand (String brand);

    Car findByModel (String model);
}
