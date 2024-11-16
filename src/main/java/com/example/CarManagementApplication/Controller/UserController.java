//package com.example.CarManagementApplication.Controller;
//
//import com.example.CarManagementApplication.DTO.UserLoginRequest;
//import com.example.CarManagementApplication.Model.User;
//import com.example.CarManagementApplication.Repository.UserRepository;
//import com.example.CarManagementApplication.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("userLogin")
//
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    private UserRepository userRepository;
//    //when posting the details
//    @PostMapping("/")
//    public ResponseEntity<?> login(@RequestBody UserLoginRequest loginRequest){
//        try{
//            boolean isAuthentic = userService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());
//            if(isAuthentic){
//                //return ResponseEntity.ok().body("User logged in");
//                return ResponseEntity.ok(Map.of("message","Login Successful"));
//            } else{
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error","Invalid credentials"));
//            }
//        } catch (Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", e.getMessage()));
//        }
//    }
//}
