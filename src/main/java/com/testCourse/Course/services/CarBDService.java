package com.testCourse.Course.services;

import java.util.ArrayList;

import com.testCourse.Course.models.CarModel;
import com.testCourse.Course.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarBDService {
    @Autowired
    CarRepository carRepository;

    public ArrayList<CarModel> getAllCars() {
        return (ArrayList<CarModel>) carRepository.findAll();
    }

    public CarModel saveCar(CarModel car) {
        return carRepository.save(car);
    }
}
