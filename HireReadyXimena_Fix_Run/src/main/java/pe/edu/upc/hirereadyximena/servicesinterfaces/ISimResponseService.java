package pe.edu.upc.hirereadyximena.servicesinterfaces;

import pe.edu.upc.hirereadyximena.entities.SimResponse;
import java.util.List;

public interface ISimResponseService {
    void insert(SimResponse simResponse);
    List<SimResponse> list();
    SimResponse listId(int id);
    void update(SimResponse simResponse);
    void delete(int id);
    List<SimResponse> findBySimulation(Integer simulationId);
}
