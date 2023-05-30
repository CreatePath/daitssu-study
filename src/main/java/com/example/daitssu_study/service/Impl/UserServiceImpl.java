package com.example.daitssu_study.service.Impl;

import com.example.daitssu_study.data.dao.UserDAO;
import com.example.daitssu_study.data.dto.request.UserCreateDto;
import com.example.daitssu_study.data.dto.response.UserDto;
import com.example.daitssu_study.data.entity.User;
import com.example.daitssu_study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDto getById(Long id) {
        User user = userDAO.findById(id);
        UserDto userDto = new UserDto().builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
        return userDto;
    }

    @Override
    public UserDto create(UserCreateDto userCreateDto) {
        User user = new User().builder()
                .email(userCreateDto.getEmail())
                .password(userCreateDto.getPassword())
                .name(userCreateDto.getName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .role(userCreateDto.getRole())
                .build();

        User createdUser = userDAO.create(user);

        UserDto userDto = new UserDto().builder()
                .id(createdUser.getId())
                .email(createdUser.getEmail())
                .name(createdUser.getName())
                .role(createdUser.getRole())
                .build();

        return userDto;
    }

    @Override
    public UserDto update(Long id, String userName) {
        return null;
    }

    @Override
    public void deleteByEmail(String email) {

    }
}
