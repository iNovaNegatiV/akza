package de.akza.jk.controller;

import de.akza.jk.Dtos.GetUserDto;
import de.akza.jk.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<GetUserDto>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.getUserById(id));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<GetUserDto> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(this.userService.getUserByUsername(username));
    }
}
