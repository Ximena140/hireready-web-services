package pe.edu.upc.hirereadyximena.repositories;

import pe.edu.upc.hirereadyximena.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
