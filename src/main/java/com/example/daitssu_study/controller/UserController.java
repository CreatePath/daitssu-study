package com.example.daitssu_study.controller;

import com.example.daitssu_study.data.dto.request.UserCreateDto;
import com.example.daitssu_study.data.dto.response.UserDto;
import com.example.daitssu_study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserCreateDto userCreateDto) {
        return userService.create(userCreateDto);
    }

    @GetMapping("/info/{idx}")
    public UserDto getUser(@PathVariable Long idx) {
        return userService.getById(idx);
    }
}
