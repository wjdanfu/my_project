package com.example.demo.controller;


import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService  = userService;
    }

    @GetMapping("check")
    public String status(){
        return "well running";
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody UserDto userDto){
        userService.createUser(userDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
