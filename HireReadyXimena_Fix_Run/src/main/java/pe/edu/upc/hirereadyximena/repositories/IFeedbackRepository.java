package pe.edu.upc.hirereadyximena.repositories;

import pe.edu.upc.hirereadyximena.dtos.ErrorCountDTO;
import pe.edu.upc.hirereadyximena.entities.Feedback;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {

    // US23 Consejos personalizados
    List<Feedback> findBySimResultResultId(Integer resultId);

    // US40 Historial de errores comunes
    @Query("SELECT new pe.edu.upc.hirereadyximena.dtos.ErrorCountDTO(f.frequentErrors, COUNT(f)) " +
            "FROM Feedback f " +
            "JOIN f.simResult r " +
            "JOIN r.simulation s " +
            "WHERE s.user.userId = :userId " +
            "GROUP BY f.frequentErrors")
    List<ErrorCountDTO> findFrequentErrorsByUser(Integer userId);
}
