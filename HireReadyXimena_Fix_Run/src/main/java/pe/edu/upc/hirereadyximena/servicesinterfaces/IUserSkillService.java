package pe.edu.upc.hirereadyximena.servicesinterfaces;

import pe.edu.upc.hirereadyximena.entities.UserSkill;
import java.util.List;

public interface IUserSkillService {
    void insert(UserSkill userSkill);
    List<UserSkill> list();
    UserSkill listId(int id);
    void update(UserSkill userSkill);
    void delete(int id);
    List<UserSkill> findByProfile(Integer profileId);
}
