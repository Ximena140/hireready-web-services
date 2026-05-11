package pe.edu.upc.hirereadyximena.servicesinterfaces;

import pe.edu.upc.hirereadyximena.entities.Feedback;
import pe.edu.upc.hirereadyximena.dtos.ErrorCountDTO;
import java.util.List;

public interface IFeedbackService {
    void insert(Feedback feedback);
    List<Feedback> list();
    Feedback listId(int id);
    void update(Feedback feedback);
    void delete(int id);
    List<Feedback> findByResult(Integer resultId);
    List<ErrorCountDTO> findFrequentErrors(Integer userId);
}
