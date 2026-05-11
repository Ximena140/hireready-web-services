package pe.edu.upc.hirereadyximena.servicesimplements;

import pe.edu.upc.hirereadyximena.entities.UserSkill;
import pe.edu.upc.hirereadyximena.repositories.IUserSkillRepository;
import pe.edu.upc.hirereadyximena.servicesinterfaces.IUserSkillService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserSkillServiceImplement implements IUserSkillService {
    private final IUserSkillRepository repository;

    public UserSkillServiceImplement(IUserSkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(UserSkill userSkill) {
        repository.save(userSkill);
    }

    @Override
    public List<UserSkill> list() {
        return repository.findAll();
    }

    @Override
    public UserSkill listId(int id) {
        return repository.findById(id).orElse(new UserSkill());
    }

    @Override
    public void update(UserSkill userSkill) {
        repository.save(userSkill);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override public List<UserSkill> findByProfile(Integer profileId) {
        return repository.findByProfileProfileId(profileId);
    }
}
