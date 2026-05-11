package pe.edu.upc.hirereadyximena.controllers;

import pe.edu.upc.hirereadyximena.entities.Role;
import pe.edu.upc.hirereadyximena.servicesinterfaces.IRoleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final IRoleService service;

    public RoleController(IRoleService service) {
        this.service = service;
    }

    @PostMapping
    public void insert(@RequestBody Role role) {
        service.insert(role);
    }

    @GetMapping
    public List<Role> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Role listId(@PathVariable("id") int id) {
        return service.listId(id);
    }

    @PutMapping
    public void update(@RequestBody Role role) {
        service.update(role);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

}
