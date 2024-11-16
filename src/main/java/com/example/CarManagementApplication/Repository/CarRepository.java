package com.example.CarManagementApplication.Repository;

import com.example.CarManagementApplication.Model.CarDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<CarDetails, String> {
}
