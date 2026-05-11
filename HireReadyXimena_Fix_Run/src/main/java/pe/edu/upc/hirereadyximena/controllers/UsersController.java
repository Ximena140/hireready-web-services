package pe.edu.upc.hirereadyximena.controllers;

import pe.edu.upc.hirereadyximena.entities.Users;
import pe.edu.upc.hirereadyximena.servicesinterfaces.IUsersService;
import pe.edu.upc.hirereadyximena.dtos.JwtRequestDTO;
import pe.edu.upc.hirereadyximena.dtos.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final IUsersService service;

    public UsersController(IUsersService service) {
        this.service = service;
    }

    private UserDTO convertToDTO(Users user) {
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setLanguagePref(user.getLanguagePref());
        return dto;
    }

    @PostMapping
    public void insert(@RequestBody Users user) {
        service.insert(user);
    }

    @GetMapping
    public List<UserDTO> list() {
        return service.list()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDTO listId(@PathVariable("id") int id) {
        return convertToDTO(service.listId(id));
    }

    @PutMapping
    public void update(@RequestBody Users user) {
        service.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    // US02 Inicio de sesión seguro
    @PostMapping("/login")
    public UserDTO login(@RequestBody JwtRequestDTO dto) {
        return convertToDTO(service.login(dto.getUsername(), dto.getPassword()));
    }

    // US55 Asignación de roles
    @PutMapping("/{userId}/role/{roleId}")
    public int assignRole(@PathVariable Integer userId, @PathVariable Integer roleId) {
        return service.assignRole(userId, roleId);
    }

    // US05 Edición de perfil personal
    @PutMapping("/{userId}/personal-data")
    public int updatePersonalData(@PathVariable Integer userId, @RequestBody Users user) {
        return service.updatePersonalData(
                userId,
                user.getFirstName(),
                user.getLastName(),
                user.getLanguagePref()
        );
    }

    // US06 Carga de foto de perfil
    @PutMapping("/{userId}/profile-picture")
    public int updateProfilePicture(
            @PathVariable Integer userId,
            @RequestBody java.util.Map<String, String> body
    ) {
        return service.updateProfilePicture(userId, body.get("url"));
    }

    // US10 Validación de datos de registro
    @PutMapping("/{userId}/verify")
    public int verifyUser(@PathVariable Integer userId) {
        return service.verifyUser(userId);
    }

    // US11 Eliminación de cuenta
    @PutMapping("/{userId}/delete")
    public int softDeleteUser(@PathVariable Integer userId) {
        return service.softDeleteUser(userId);
    }

    // US13 Preferencias de idioma
    @PutMapping("/{userId}/language")
    public int updateLanguage(
            @PathVariable Integer userId,
            @RequestBody java.util.Map<String, String> body
    ) {
        return service.updateLanguage(userId, body.get("languagePref"));
    }

    // US04 Onboarding guiado
    @PutMapping("/{userId}/onboarding")
    public int completeOnboarding(@PathVariable Integer userId) {
        return service.completeOnboarding(userId);
    }

    // US03 Recuperación de contraseña
    @PutMapping("/recover-password")
    public int recoverPassword(@RequestBody JwtRequestDTO dto) {
        return service.recoverPassword(dto.getUsername(), dto.getPassword());
    }
}