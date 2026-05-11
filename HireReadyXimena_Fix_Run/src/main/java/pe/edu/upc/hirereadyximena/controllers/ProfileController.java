package pe.edu.upc.hirereadyximena.controllers;

import pe.edu.upc.hirereadyximena.entities.Profile;
import pe.edu.upc.hirereadyximena.servicesinterfaces.IProfileService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    private final IProfileService service;

    public ProfileController(IProfileService service) {
        this.service = service;
    }

    @PostMapping
    public void insert(@RequestBody Profile profile) {
        service.insert(profile);
    }

    @GetMapping
    public List<Profile> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Profile listId(@PathVariable("id") int id) {
        return service.listId(id);
    }

    @PutMapping
    public void update(@RequestBody Profile profile) {
        service.update(profile);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    // US08 Vinculación de LinkedIn
    @PutMapping("/user/{userId}/linkedin")
    public int updateLinkedIn(@PathVariable Integer userId, @RequestBody java.util.Map<String,String> body) {
        return service.updateLinkedIn(userId, body.get("linkedinUrl"));
    }
}
