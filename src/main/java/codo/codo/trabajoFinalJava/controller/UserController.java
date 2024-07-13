package codo.codo.trabajoFinalJava.controller;

import codo.codo.trabajoFinalJava.model.UserEntity;
import codo.codo.trabajoFinalJava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping(value="/crear", consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins= "*")
    public ResponseEntity<?> guardarUsuario(@RequestBody UserEntity usuario) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(repository.save(usuario));

    }
    @GetMapping("/todos")
    @CrossOrigin(origins= "*")
    public ResponseEntity<?> listaUsuarios() {
        Optional<Iterable<UserEntity>> optional = Optional.of(repository.findAll());
            return ResponseEntity.status(HttpStatus.OK).body(optional.get());

    }





}
