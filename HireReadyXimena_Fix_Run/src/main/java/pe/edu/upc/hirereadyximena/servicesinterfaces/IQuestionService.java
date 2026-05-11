package pe.edu.upc.hirereadyximena.servicesinterfaces;

import pe.edu.upc.hirereadyximena.entities.Question;
import java.util.List;

public interface IQuestionService {
    void insert(Question question);
    List<Question> list();
    Question listId(int id);
    void update(Question question);
    void delete(int id);
    List<Question> findByDifficulty(String difficulty);
    List<Question> findByCategory(String category);
}
