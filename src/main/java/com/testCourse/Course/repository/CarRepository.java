package com.testCourse.Course.repository;

import com.testCourse.Course.models.CarModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<CarModel, Long> {

}
