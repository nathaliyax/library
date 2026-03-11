package org.example.biblioteca.controller;

import jakarta.validation.Valid;
import org.example.biblioteca.DTO.UsuarioRequestDTO;
import org.example.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> saveUser(@Valid @RequestBody UsuarioRequestDTO user){
        return ResponseEntity.ok(usuarioService.saveUser(user));
    }

    @GetMapping
    public ResponseEntity<?> listUsers(){
        return ResponseEntity.ok(usuarioService.listUsers());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id){
        return ResponseEntity.ok(usuarioService.deleteUser(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchUser(@PathVariable long id){
        return ResponseEntity.ok(usuarioService.searchUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody UsuarioRequestDTO user) {
        return ResponseEntity.ok(usuarioService.updateUser(id, user));
    }
}

