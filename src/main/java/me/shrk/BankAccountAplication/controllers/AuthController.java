package me.shrk.BankAccountAplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.shrk.BankAccountAplication.dtos.LoginDTO;
import me.shrk.BankAccountAplication.dtos.RegisterDTO;
import me.shrk.BankAccountAplication.models.User;
import me.shrk.BankAccountAplication.security.TokenService;
import me.shrk.BankAccountAplication.services.UserService;

@RestController
@RequestMapping("/auth")
@SuppressWarnings("rawtypes")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService service;
    @Autowired
    private TokenService tokenService;
    
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO data){
        
        var emailPass = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = authenticationManager.authenticate(emailPass);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO data){
        if(service.create(data) == null) return ResponseEntity.badRequest().build();
        else return ResponseEntity.ok().build();
    }
}
