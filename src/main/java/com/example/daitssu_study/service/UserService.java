package com.example.daitssu_study.service;

import com.example.daitssu_study.data.dto.request.UserCreateDto;
import com.example.daitssu_study.data.dto.response.UserDto;

public interface UserService {

    UserDto getById(Long id);

    UserDto create(UserCreateDto userCreateDto);

    UserDto update(Long id, String userName);

    void deleteByEmail(String email);
}
