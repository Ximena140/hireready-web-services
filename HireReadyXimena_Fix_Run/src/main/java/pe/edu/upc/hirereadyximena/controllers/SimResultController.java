package pe.edu.upc.hirereadyximena.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.hirereadyximena.dtos.ProgressDTO;
import pe.edu.upc.hirereadyximena.entities.SimResult;
import pe.edu.upc.hirereadyximena.servicesinterfaces.ISimResultService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/sim-results")
public class SimResultController {

    private final ISimResultService service;

    public SimResultController(ISimResultService service) {
        this.service = service;
    }

    //student
    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping
    public void insert(@RequestBody SimResult simResult) {
        service.insert(simResult);
    }

    //student, admin
    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")
    @GetMapping
    public List<SimResult> list() {
        return service.list();
    }

    //student, admin
    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")
    @GetMapping("/{id}")
    public SimResult listId(@PathVariable("id") int id) {
        return service.listId(id);
    }

    //student
    @PreAuthorize("hasRole('STUDENT')")
    @PutMapping
    public void update(@RequestBody SimResult simResult) {
        service.update(simResult);
    }

    //admin
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }


    // US54 Resumen IA (student)
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/simulation/{simulationId}/summary")
    public String findAiSummary(
            @PathVariable Integer simulationId
    ) {
        return service.findAiSummary(simulationId);
    }

    // US34 Panel progreso (student)
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/user/{userId}/progress")
    public List<ProgressDTO> findProgressByUser(
            @PathVariable Integer userId
    ) {
        return service.findProgressByUser(userId);
    }

    // US44 Resultados bajos (recrutier, admin)
    @PreAuthorize("hasAnyRole('RECRUITER','ADMIN')")
    @GetMapping("/low-scores/{score}")
    public List<SimResult> findLowScores(
            @PathVariable BigDecimal score
    ) {
        return service.findLowScores(score);
    }

    // US26 Comparación carrera (recrutier, admin)
    @PreAuthorize("hasAnyRole('RECRUITER','ADMIN')")
    @GetMapping("/career-average/{career}")
    public BigDecimal averageByCareer(
            @PathVariable String career
    ) {
        return service.averageByCareer(career);
    }
}