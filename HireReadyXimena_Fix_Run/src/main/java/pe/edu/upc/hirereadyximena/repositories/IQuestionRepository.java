package pe.edu.upc.hirereadyximena.repositories;

import pe.edu.upc.hirereadyximena.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IQuestionRepository extends JpaRepository<Question, Integer> {
    // US17 Práctica de preguntas difíciles
    List<Question> findByDifficulty(String difficulty);

    // US57 Gestión del banco de preguntas
    List<Question> findByCategory(String category);
}
