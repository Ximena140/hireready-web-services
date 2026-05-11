package pe.edu.upc.hirereadyximena.repositories;

import pe.edu.upc.hirereadyximena.entities.Simulation;
import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface ISimulationRepository extends JpaRepository<Simulation, Integer> {
    // US19 Filtro por nivel de dificultad
    List<Simulation> findByUserUserIdAndDifficulty(Integer userId, String difficulty);

    // US31 Reanudación de entrevistas
    List<Simulation> findByUserUserIdAndStatus(Integer userId, String status);

    // US15 Selección de modo de entrevista
    @Modifying @Transactional
    @Query("UPDATE Simulation s " +
            "SET s.mode = :mode " +
            "WHERE s.simulationId = :simulationId")
    int updateMode(Integer simulationId, String mode);

    // US18 Duración personalizada
    @Modifying @Transactional
    @Query("UPDATE Simulation s " +
            "SET s.durationMins = :durationMins " +
            "WHERE s.simulationId = :simulationId")
    int updateDuration(Integer simulationId, Integer durationMins);

    // US47 Activación del Coach Virtual
    @Modifying @Transactional
    @Query("UPDATE Simulation s " +
            "SET s.coachActive = true " +
            "WHERE s.simulationId = :simulationId")
    int activateCoach(Integer simulationId);

    // US51 Simulaciones bilingües
    @Modifying @Transactional
    @Query("UPDATE Simulation s " +
            "SET s.simLanguage = :language " +
            "WHERE s.simulationId = :simulationId")
    int updateLanguage(Integer simulationId, String language);
}
