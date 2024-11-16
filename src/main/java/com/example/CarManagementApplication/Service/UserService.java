//package com.example.CarManagementApplication.Service;
//
//import com.example.CarManagementApplication.Model.User;
//import com.example.CarManagementApplication.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    public boolean authenticateUser(String email, String password) {
//        Optional<User> user = userRepository.findByEmail(email);
//        //Optional<User> user = userRepository.findById(email);
//        return user.isPresent() && user.get().getPassword().equals(password);
//
//    }
//}
//
