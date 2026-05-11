package pe.edu.upc.hirereadyximena.repositories;

import pe.edu.upc.hirereadyximena.entities.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IUserSkillRepository extends JpaRepository<UserSkill, Integer> {
    // US56 Gestión de habilidades
    List<UserSkill> findByProfileProfileId(Integer profileId);
}
