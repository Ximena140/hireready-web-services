package pe.edu.upc.hirereadyximena.servicesimplements;

import pe.edu.upc.hirereadyximena.entities.Feedback;
import pe.edu.upc.hirereadyximena.repositories.IFeedbackRepository;
import pe.edu.upc.hirereadyximena.servicesinterfaces.IFeedbackService;
import pe.edu.upc.hirereadyximena.dtos.ErrorCountDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeedbackServiceImplement implements IFeedbackService {
    private final IFeedbackRepository repository;

    public FeedbackServiceImplement(IFeedbackRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(Feedback feedback) {
        repository.save(feedback);
    }

    @Override
    public List<Feedback> list() {
        return repository.findAll();
    }

    @Override
    public Feedback listId(int id) {
        return repository.findById(id).orElse(new Feedback());
    }

    @Override
    public void update(Feedback feedback) {
        repository.save(feedback);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override public List<Feedback> findByResult(Integer resultId) {
        return repository.findBySimResultResultId(resultId);
    }

    @Override public List<ErrorCountDTO> findFrequentErrors(Integer userId) {
        return repository.findFrequentErrorsByUser(userId);
    }
}
