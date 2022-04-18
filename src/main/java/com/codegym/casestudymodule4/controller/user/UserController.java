package com.codegym.casestudymodule4.controller.user;

import com.codegym.casestudymodule4.model.user.User;
import com.codegym.casestudymodule4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<Page<User>> fillAllProduct(@PageableDefault(size = 5) Pageable pageable) {
        Page<User> userPage = userService.findAllUser(pageable);
        if (userPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userPage, HttpStatus.OK);
    }

    @GetMapping("/viewUserByName")
    public ResponseEntity<User> fillAllProductByUser(@RequestParam(name = "q") Optional<String> q) {
        User user = null;
        if (q.isPresent()) {
            user = userService.findByUsername(q.get());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> editUser(@PathVariable Long id) {
        Optional<User> user1 = userService.findById(id);
        if (!user1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/validated/username")
    public ResponseEntity<?> validateUserName(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            User userFindByUsername = userService.findByUsername(user.getUsername());
            return new ResponseEntity<>(userFindByUsername, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new User(), HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setId(userOptional.get().getId());
        user.setFullName(userOptional.get().getFullName());
        user.setUsername(userOptional.get().getUsername());
        user.setPassword(userOptional.get().getPassword());
        user.setEmail(userOptional.get().getEmail());
        user.setPhoneNumber(userOptional.get().getPhoneNumber());
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }
}



