package pe.edu.upc.hirereadyximena.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.hirereadyximena.dtos.ErrorCountDTO;
import pe.edu.upc.hirereadyximena.entities.Feedback;
import pe.edu.upc.hirereadyximena.servicesinterfaces.IFeedbackService;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final IFeedbackService service;

    public FeedbackController(IFeedbackService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping
    public void insert(@RequestBody Feedback feedback) {
        service.insert(feedback);
    }

    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")
    @GetMapping
    public List<Feedback> list() {
        return service.list();
    }

    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")
    @GetMapping("/{id}")
    public Feedback listId(@PathVariable("id") int id) {
        return service.listId(id);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @PutMapping
    public void update(@RequestBody Feedback feedback) {
        service.update(feedback);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    // US23 Consejos personalizados
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/result/{resultId}")
    public List<Feedback> findByResult(
            @PathVariable Integer resultId
    ) {
        return service.findByResult(resultId);
    }

    // US40 Errores frecuentes
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/user/{userId}/frequent-errors")
    public List<ErrorCountDTO> findFrequentErrors(
            @PathVariable Integer userId
    ) {
        return service.findFrequentErrors(userId);
    }
}