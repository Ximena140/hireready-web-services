package pe.edu.upc.hirereadyximena.repositories;

import pe.edu.upc.hirereadyximena.dtos.ProgressDTO;
import pe.edu.upc.hirereadyximena.entities.SimResult;
import org.springframework.data.jpa.repository.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ISimResultRepository extends JpaRepository<SimResult, Integer> {
    Optional<SimResult> findBySimulationSimulationId(Integer simulationId);

    // US54 Resumen de desempeño final
    @Query("SELECT r.aiSummary " +
            "FROM SimResult r " +
            "WHERE r.simulation.simulationId = :simulationId")
    String findAiSummaryBySimulationId(Integer simulationId);

    // US34 Panel de progreso
    @Query("SELECT new pe.edu.upc.hirereadyximena.dtos.ProgressDTO(s.simulationId, s.mode, s.difficulty, r.overallScore, r.verbalScore, r.emotionalScore, r.technicalScore) " +
            "FROM SimResult r " +
            "JOIN r.simulation s " +
            "WHERE s.user.userId = :userId")
    List<ProgressDTO> findProgressByUser(Integer userId);

    // US44 Filtro de desempeño por categoría
    @Query("SELECT r " +
            "FROM SimResult r " +
            "WHERE r.technicalScore < :score " +
            "OR r.verbalScore < :score " +
            "OR r.emotionalScore < :score")
    List<SimResult> findLowScores(BigDecimal score);

    // US26 Comparación con otros usuarios
    @Query("SELECT AVG(r.overallScore) " +
            "FROM SimResult r JOIN r.simulation s " +
            "JOIN Profile p ON p.user.userId = s.user.userId " +
            "WHERE p.career = :career")
    BigDecimal averageByCareer(String career);
}
