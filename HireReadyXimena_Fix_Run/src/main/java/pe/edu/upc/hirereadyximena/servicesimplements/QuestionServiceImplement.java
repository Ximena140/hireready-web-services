package pe.edu.upc.hirereadyximena.servicesimplements;

import pe.edu.upc.hirereadyximena.entities.Question;
import pe.edu.upc.hirereadyximena.repositories.IQuestionRepository;
import pe.edu.upc.hirereadyximena.servicesinterfaces.IQuestionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionServiceImplement implements IQuestionService {
    private final IQuestionRepository repository;

    public QuestionServiceImplement(IQuestionRepository repository) {
        this.repository = repository;

    }

    @Override
    public void insert(Question question) {
        repository.save(question);
    }

    @Override
    public List<Question> list() {
        return repository.findAll();
    }

    @Override
    public Question listId(int id) {
        return repository.findById(id).orElse(new Question());
    }

    @Override
    public void update(Question question) {
        repository.save(question);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override public List<Question> findByDifficulty(String difficulty) {
        return repository.findByDifficulty(difficulty);
    }

    @Override public List<Question> findByCategory(String category) {
        return repository.findByCategory(category);
    }
}
