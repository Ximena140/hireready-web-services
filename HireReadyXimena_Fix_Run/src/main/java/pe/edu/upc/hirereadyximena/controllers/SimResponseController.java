package pe.edu.upc.hirereadyximena.controllers;

import pe.edu.upc.hirereadyximena.entities.SimResponse;
import pe.edu.upc.hirereadyximena.servicesinterfaces.ISimResponseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sim-responses")
public class SimResponseController {
    private final ISimResponseService service;

    public SimResponseController(ISimResponseService service) {
        this.service = service;
    }

    @PostMapping
    public void insert(@RequestBody SimResponse simResponse) {
        service.insert(simResponse);
    }

    @GetMapping
    public List<SimResponse> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public SimResponse listId(@PathVariable("id") int id) {
        return service.listId(id);
    }

    @PutMapping
    public void update(@RequestBody SimResponse simResponse) {
        service.update(simResponse);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    // US33 Asistencia virtual con IA
    @GetMapping("/simulation/{simulationId}")
    public List<SimResponse> findBySimulation(@PathVariable Integer simulationId) {
        return service.findBySimulation(simulationId);
    }
}
