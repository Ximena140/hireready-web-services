package pe.edu.upc.hirereadyximena.repositories;

import pe.edu.upc.hirereadyximena.entities.SimResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ISimResponseRepository extends JpaRepository<SimResponse, Integer> {
    // US33 Asistencia virtual con IA
    List<SimResponse> findBySimulationSimulationId(Integer simulationId);
}
