package com.br.todo.controller;

import com.br.todo.entity.User;
import com.br.todo.entity.form.AuthDTO;
import com.br.todo.entity.form.LoginResponse;
import com.br.todo.entity.form.RegisterDTO;
import com.br.todo.infra.config.TokenService;
import com.br.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/auth")
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    TokenService tokenService;


    @GetMapping("/whoami")
    public ResponseEntity<Object> whoami (@RequestHeader HttpHeaders data) {
        var token = data.get("Authorization").get(0);
        if (token != null) {
            var login = tokenService.validateToken(token.replace("Bearer ", ""));
            UserDetails user = userRepository.findByLogin(login); // TODO: DTO PARA RESPONSE DISSO
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();

    }
    @PostMapping("/login")
    public ResponseEntity<Object> login (@RequestBody @Validated AuthDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponse(token));

    }



    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Validated RegisterDTO data) {
        if (this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());


        User newUser = new User(data.login(), encryptedPassword, data.role());

        this.userRepository.save(newUser);

        return  ResponseEntity.ok().build();
    }
}
