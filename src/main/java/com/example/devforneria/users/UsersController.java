package com.example.devforneria.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<Users> findAll() {
        return usersService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id) {
        return usersService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
    @PostMapping
    public Users createUsers(@RequestBody Users user) {
        return usersService.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUsers(@PathVariable Long id, @RequestBody Users user) {
        try{
            Users existingUser = usersService.updateUsers(id, user);
            return ResponseEntity.ok(existingUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsers(Long id) {
        usersService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
