package com.senati.senati_web_moreno.service;

import com.senati.senati_web_moreno.model.Response;
import com.senati.senati_web_moreno.model.User;
import com.senati.senati_web_moreno.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<User> saveUser(User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
  /*
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    } */

    public ResponseEntity<User> updateUser(Integer id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User u = existingUser.get();
            u.setName(user.getName());
            u.setLastname(user.getLastname());
            userRepository.save(u);
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Response deleteUser(int id){
        Optional<User> optionalUser = userRepository.findById(id);
        Response response = new Response();

        if (optionalUser.isPresent()){
            response.setCode(200);
            response.setStatus("success");
            response.setMessage("El usuario con id: " + id + "se ha eliminado correctamente");
            return response;
        }

        response.setCode(404);
        response.setStatus("error");
        response.setMessage("No se puede eliminar el usuario");


        return response;
    }
}

