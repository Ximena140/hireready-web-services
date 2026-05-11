package pe.edu.upc.hirereadyximena.servicesinterfaces;

import pe.edu.upc.hirereadyximena.entities.Simulation;
import java.util.List;

public interface ISimulationService {
    void insert(Simulation simulation);
    List<Simulation> list();
    Simulation listId(int id);
    void update(Simulation simulation);
    void delete(int id);
    int updateMode(Integer simulationId, String mode);
    int updateDuration(Integer simulationId, Integer durationMins);
    int activateCoach(Integer simulationId);
    int updateLanguage(Integer simulationId, String language);
    List<Simulation> findByDifficulty(Integer userId, String difficulty);
    List<Simulation> findIncomplete(Integer userId);
}
