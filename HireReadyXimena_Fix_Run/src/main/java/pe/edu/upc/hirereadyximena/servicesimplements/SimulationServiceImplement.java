package pe.edu.upc.hirereadyximena.servicesimplements;

import pe.edu.upc.hirereadyximena.entities.Simulation;
import pe.edu.upc.hirereadyximena.repositories.ISimulationRepository;
import pe.edu.upc.hirereadyximena.servicesinterfaces.ISimulationService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SimulationServiceImplement implements ISimulationService {
    private final ISimulationRepository repository;

    public SimulationServiceImplement(ISimulationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(Simulation simulation) {
        repository.save(simulation);
    }

    @Override
    public List<Simulation> list() {
        return repository.findAll();
    }

    @Override
    public Simulation listId(int id) {
        return repository.findById(id).orElse(new Simulation());
    }

    @Override
    public void update(Simulation simulation) {
        repository.save(simulation);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override public int updateMode(Integer simulationId, String mode) {
        return repository.updateMode(simulationId, mode);
    }

    @Override public int updateDuration(Integer simulationId, Integer durationMins) {
        return repository.updateDuration(simulationId, durationMins); }

    @Override public int activateCoach(Integer simulationId) {
        return repository.activateCoach(simulationId);
    }

    @Override public int updateLanguage(Integer simulationId, String language) {
        return repository.updateLanguage(simulationId, language);
    }

    @Override public List<Simulation> findByDifficulty(Integer userId, String difficulty) {
        return repository.findByUserUserIdAndDifficulty(userId, difficulty);
    }

    @Override public List<Simulation> findIncomplete(Integer userId) {
        return repository.findByUserUserIdAndStatus(userId, "incomplete");
    }
}
