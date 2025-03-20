package com.example.devforneria.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    public Users save(Users users) {
        return usersRepository.save(users);
    }

    public Users updateUsers(Long id, Users users) {
        Users existingUser = usersRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Usuario inexistente")
        );
        existingUser.setName(users.getName());
        existingUser.setEmail(users.getEmail());
        existingUser.setPassword(users.getPassword());
        return usersRepository.save(existingUser);
    }

    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }

    public Optional<Users> findByEmail(String Email) {
        return usersRepository.findByEmail(Email);
    }

}
