package com.HMS.hms.Controller;
import com.HMS.hms.Service.UserService;
import com.HMS.hms.Tables.Users;
import com.HMS.hms.Repo.UsersRepo;


import com.HMS.hms.Tables.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody Users user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Long id) {
        return userService.findByUserId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

