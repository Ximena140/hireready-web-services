package pe.edu.upc.hirereadyximena.servicesinterfaces;

import pe.edu.upc.hirereadyximena.entities.SimResult;
import pe.edu.upc.hirereadyximena.dtos.ProgressDTO;
import java.math.BigDecimal;
import java.util.List;

public interface ISimResultService {
    void insert(SimResult simResult);
    List<SimResult> list();
    SimResult listId(int id);
    void update(SimResult simResult);
    void delete(int id);
    String findAiSummary(Integer simulationId);
    List<ProgressDTO> findProgressByUser(Integer userId);
    List<SimResult> findLowScores(BigDecimal score);
    BigDecimal averageByCareer(String career);
}
