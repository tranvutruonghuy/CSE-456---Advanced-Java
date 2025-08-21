package com.example.FinalMockTest.service;

import com.example.FinalMockTest.model.User;
import com.example.FinalMockTest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //Tiêm repo
    @Autowired
    private UserRepo userRepo;

    //Hàm phục vụ lưu user
    public void save(User user){
        userRepo.save(user);
    }

    //Hàm phục vụ login
    public User findByUsername(String userName){
        return userRepo.searchUserByUsernameIgnoreCase(userName);
    }
//    public List<User> findList(String keyword){
//    }
}
