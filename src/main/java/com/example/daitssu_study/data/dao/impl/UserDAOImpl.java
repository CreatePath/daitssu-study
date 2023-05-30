package com.example.daitssu_study.data.dao.impl;

import com.example.daitssu_study.data.dao.UserDAO;
import com.example.daitssu_study.data.entity.User;
import com.example.daitssu_study.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserDAOImpl implements UserDAO {

    private UserRepository userRepository;

    @Autowired
    public UserDAOImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User update(Long id, String userName) throws Exception {
        Optional<User> selectedUser = userRepository.findById(id);

        User updatedUser;
        if (selectedUser.isPresent()) {
            User user = selectedUser.get();

            user.setName(userName);
            user.setUpdatedAt(LocalDateTime.now());

            updatedUser = userRepository.save(user);
        } else {
            throw new Exception();
        }

        return updatedUser;
    }

    @Override
    public User findByEmail(String email) throws Exception {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent())
            return user.get();
        else
            throw new Exception();
    }

    @Override
    public void deleteByEmail(String email) throws Exception {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent())
            userRepository.delete(user.get());
        else
            throw new Exception();
    }
}
