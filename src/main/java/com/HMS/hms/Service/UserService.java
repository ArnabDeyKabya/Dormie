package com.HMS.hms.Service;
import com.HMS.hms.Repo.UsersRepo;
import com.HMS.hms.Tables.Users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UsersRepo userRepo;

    @Autowired
    public UserService(UsersRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Users registerUser(Users user) {
        return userRepo.save(user);
    }
    public Optional<Users> findByUserId(Long userId) {
        return userRepo.findByUserId(userId);
    }
}
