package pe.edu.upc.hirereadyximena.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.hirereadyximena.entities.Simulation;
import pe.edu.upc.hirereadyximena.servicesinterfaces.ISimulationService;

import java.util.List;

@RestController
@RequestMapping("/api/simulations")
public class SimulationController {

    private final ISimulationService service;

    public SimulationController(ISimulationService service) {
        this.service = service;
    }

    // US14 Crear simulación (student)
    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping
    public void insert(@RequestBody Simulation simulation) {
        service.insert(simulation);
    }

    // Ver simulaciones (student, admin)
    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")
    @GetMapping
    public List<Simulation> list() {
        return service.list();
    }

    // Ver por id (student, admin)
    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")
    @GetMapping("/{id}")
    public Simulation listId(@PathVariable("id") int id) {
        return service.listId(id);
    }

    // Actualizar (student)
    @PreAuthorize("hasRole('STUDENT')")
    @PutMapping
    public void update(@RequestBody Simulation simulation) {
        service.update(simulation);
    }

    // Eliminar (admin)
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    // US15 Selección de modo (student)
    @PreAuthorize("hasRole('STUDENT')")
    @PutMapping("/{simulationId}/mode")
    public int updateMode(
            @PathVariable Integer simulationId,
            @RequestBody java.util.Map<String,String> body
    ) {
        return service.updateMode(simulationId, body.get("mode"));
    }

    // US18 Duración personalizada (student)
    @PreAuthorize("hasRole('STUDENT')")
    @PutMapping("/{simulationId}/duration")
    public int updateDuration(
            @PathVariable Integer simulationId,
            @RequestBody java.util.Map<String,Integer> body
    ) {
        return service.updateDuration(
                simulationId,
                body.get("durationMins")
        );
    }

    // US47 Coach virtual (student)
    @PreAuthorize("hasRole('STUDENT')")
    @PutMapping("/{simulationId}/coach")
    public int activateCoach(@PathVariable Integer simulationId) {
        return service.activateCoach(simulationId);
    }

    // US51 Simulación bilingüe (student)
    @PreAuthorize("hasRole('STUDENT')")
    @PutMapping("/{simulationId}/language")
    public int updateLanguage(
            @PathVariable Integer simulationId,
            @RequestBody java.util.Map<String,String> body
    ) {
        return service.updateLanguage(
                simulationId,
                body.get("language")
        );
    }

    // US19 Filtrar dificultad (student)
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/user/{userId}/difficulty/{difficulty}")
    public List<Simulation> findByDifficulty(
            @PathVariable Integer userId,
            @PathVariable String difficulty
    ) {
        return service.findByDifficulty(userId, difficulty);
    }

    // US31 Reanudar simulación (student)
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/user/{userId}/incomplete")
    public List<Simulation> findIncomplete(
            @PathVariable Integer userId
    ) {
        return service.findIncomplete(userId);
    }
}