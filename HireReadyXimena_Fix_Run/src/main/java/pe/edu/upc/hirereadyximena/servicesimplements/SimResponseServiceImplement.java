package pe.edu.upc.hirereadyximena.servicesimplements;

import pe.edu.upc.hirereadyximena.entities.SimResponse;
import pe.edu.upc.hirereadyximena.repositories.ISimResponseRepository;
import pe.edu.upc.hirereadyximena.servicesinterfaces.ISimResponseService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SimResponseServiceImplement implements ISimResponseService {
    private final ISimResponseRepository repository;

    public SimResponseServiceImplement(ISimResponseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(SimResponse simResponse) {
        repository.save(simResponse);
    }

    @Override
    public List<SimResponse> list() {
        return repository.findAll();
    }

    @Override
    public SimResponse listId(int id) {
        return repository.findById(id).orElse(new SimResponse());
    }

    @Override
    public void update(SimResponse simResponse) {
        repository.save(simResponse);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override public List<SimResponse> findBySimulation(Integer simulationId) {
        return repository.findBySimulationSimulationId(simulationId);
    }
}
