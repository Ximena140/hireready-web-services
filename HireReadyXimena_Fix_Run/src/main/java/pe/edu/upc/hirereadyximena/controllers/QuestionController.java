package pe.edu.upc.hirereadyximena.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.hirereadyximena.entities.Question;
import pe.edu.upc.hirereadyximena.servicesinterfaces.IQuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final IQuestionService service;

    public QuestionController(IQuestionService service) {
        this.service = service;
    }

    // admin
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void insert(@RequestBody Question question) {
        service.insert(question);
    }

    // student, recruiter, admin
    @PreAuthorize("hasAnyRole('STUDENT','RECRUITER','ADMIN')")
    @GetMapping
    public List<Question> list() {
        return service.list();
    }

    // student, recruiter, admin
    @PreAuthorize("hasAnyRole('STUDENT','RECRUITER','ADMIN')")
    @GetMapping("/{id}")
    public Question listId(@PathVariable("id") int id) {
        return service.listId(id);
    }

    // admin
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public void update(@RequestBody Question question) {
        service.update(question);
    }

    // admin
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    // US17 Preguntas difíciles (student)
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/difficulty/{difficulty}")
    public List<Question> findByDifficulty(
            @PathVariable String difficulty
    ) {
        return service.findByDifficulty(difficulty);
    }

    // US57 Banco preguntas (admin)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/category/{category}")
    public List<Question> findByCategory(
            @PathVariable String category
    ) {
        return service.findByCategory(category);
    }
}