package com.example.daitssu_study.data.dao;

import com.example.daitssu_study.data.entity.User;

public interface UserDAO {
    User create(User user);

    User update(Long id, String userName) throws Exception;

    User findById(Long id);

    User findByEmail(String email) throws Exception;

    void deleteByEmail(String email) throws Exception;
}
