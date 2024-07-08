package me.shrk.BankAccountAplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import me.shrk.BankAccountAplication.dtos.UpdateDTO;
import me.shrk.BankAccountAplication.models.User;
import me.shrk.BankAccountAplication.services.UserService;

@RestController
@RequestMapping("/users")
@SuppressWarnings("rawtypes")
public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping("/listAll")
    public ResponseEntity<Iterable<User>> listAll(){
        return ResponseEntity.ok(service.listUsers());
    }

    @GetMapping("/FindOne/{id}")
    public ResponseEntity<User> findOne(@PathParam("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    
    @PutMapping("/updateUser/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody UpdateDTO data){
        if(service.update(id, data)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
