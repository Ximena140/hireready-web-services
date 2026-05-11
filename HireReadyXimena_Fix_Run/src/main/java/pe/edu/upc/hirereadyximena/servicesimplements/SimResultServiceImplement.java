package pe.edu.upc.hirereadyximena.servicesimplements;

import pe.edu.upc.hirereadyximena.entities.SimResult;
import pe.edu.upc.hirereadyximena.repositories.ISimResultRepository;
import pe.edu.upc.hirereadyximena.servicesinterfaces.ISimResultService;
import pe.edu.upc.hirereadyximena.dtos.ProgressDTO;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SimResultServiceImplement implements ISimResultService {
    private final ISimResultRepository repository;

    public SimResultServiceImplement(ISimResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(SimResult simResult) {
        repository.save(simResult);
    }

    @Override
    public List<SimResult> list() {
        return repository.findAll();
    }

    @Override
    public SimResult listId(int id) {
        return repository.findById(id).orElse(new SimResult());
    }

    @Override
    public void update(SimResult simResult) {
        repository.save(simResult);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override public String findAiSummary(Integer simulationId) {
        return repository.findAiSummaryBySimulationId(simulationId);
    }

    @Override public List<ProgressDTO> findProgressByUser(Integer userId) {
        return repository.findProgressByUser(userId);
    }

    @Override public List<SimResult> findLowScores(BigDecimal score) {
        return repository.findLowScores(score);
    }

    @Override public BigDecimal averageByCareer(String career) {
        return repository.averageByCareer(career);
    }

}
