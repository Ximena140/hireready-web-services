package pe.edu.upc.hirereadyximena.controllers;

import pe.edu.upc.hirereadyximena.entities.UserSkill;
import pe.edu.upc.hirereadyximena.servicesinterfaces.IUserSkillService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user-skills")
public class UserSkillController {
    private final IUserSkillService service;

    public UserSkillController(IUserSkillService service) {
        this.service = service;
    }

    @PostMapping
    public void insert(@RequestBody UserSkill userSkill) {
        service.insert(userSkill);
    }

    @GetMapping
    public List<UserSkill> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public UserSkill listId(@PathVariable("id") int id) {
        return service.listId(id);
    }

    @PutMapping
    public void update(@RequestBody UserSkill userSkill) {
        service.update(userSkill);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    // US56 Gestión de habilidades
    @GetMapping("/profile/{profileId}")
    public List<UserSkill> findByProfile(@PathVariable Integer profileId) {
        return service.findByProfile(profileId);
    }
}
