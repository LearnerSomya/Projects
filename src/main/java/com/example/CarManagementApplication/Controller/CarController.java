package com.example.CarManagementApplication.Controller;

import com.example.CarManagementApplication.Model.CarDetails;
import com.example.CarManagementApplication.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carDetails")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    //when posting the details
    @PostMapping("/postCarDetails")
    public ResponseEntity<?> addCarDetails(@RequestBody CarDetails carDetailsObject) {
        CarDetails saveCarDetails = this.carRepository.save(carDetailsObject);
        return ResponseEntity.ok(saveCarDetails);
    }

    //when fetching the details
    @GetMapping("/getCarDetails")
    public ResponseEntity<?> getCarDetails() {

        return ResponseEntity.ok(this.carRepository.findAll());
    }
}
