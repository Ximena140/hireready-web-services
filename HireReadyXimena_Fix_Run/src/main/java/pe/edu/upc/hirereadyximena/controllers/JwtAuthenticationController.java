package pe.edu.upc.hirereadyximena.controllers;

import pe.edu.upc.hirereadyximena.dtos.JwtRequestDTO;
import pe.edu.upc.hirereadyximena.dtos.JwtResponseDTO;
import pe.edu.upc.hirereadyximena.entities.Users;
import pe.edu.upc.hirereadyximena.repositories.IUserRepository;
import pe.edu.upc.hirereadyximena.securities.JwtUtil;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    private final JwtUtil jwtUtil;
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public JwtAuthenticationController(
            JwtUtil jwtUtil,
            IUserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {

        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/authenticate")
    public JwtResponseDTO createAuthenticationToken(
            @RequestBody JwtRequestDTO request
    ) {

        Users user =
                userRepository
                        .findByEmail(request.getUsername())
                        .orElseThrow(() ->
                                new ResponseStatusException(
                                        HttpStatus.UNAUTHORIZED,
                                        "Usuario no encontrado"
                                )
                        );
        String storedPassword =
                user.getPasswordHash();
        boolean passwordCorrect;
        // por si ya esta encriptada en passwordHash
        if (
                storedPassword != null
                        && storedPassword.startsWith("$2")
        ) {
            passwordCorrect =
                    passwordEncoder.matches(
                            request.getPassword(),
                            storedPassword
                    );
        } else {
            // para compatibilidad con contrseñas antiguas (antes de actualizar)
            passwordCorrect =
                    storedPassword.equals(
                            request.getPassword()
                    );
        }
        if (!passwordCorrect) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Contraseña incorrecta"
            );
        }
        // OBTENER ROL
        String role =
                user.getRole().getRoleType();
        // GENERAR TOKEN
        String token =
                jwtUtil.generateToken(
                        user.getEmail(),
                        role
                );
        JwtResponseDTO response =
                new JwtResponseDTO();
        response.setJwtToken(token);
        response.setRole(role);
        return response;
    }
}