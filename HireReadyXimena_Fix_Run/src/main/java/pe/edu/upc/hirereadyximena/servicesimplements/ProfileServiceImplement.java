package pe.edu.upc.hirereadyximena.servicesimplements;

import pe.edu.upc.hirereadyximena.entities.Profile;
import pe.edu.upc.hirereadyximena.repositories.IProfileRepository;
import pe.edu.upc.hirereadyximena.servicesinterfaces.IProfileService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfileServiceImplement implements IProfileService {
    private final IProfileRepository repository;

    public ProfileServiceImplement(IProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(Profile profile) {
        repository.save(profile);
    }

    @Override
    public List<Profile> list() {
        return repository.findAll();
    }

    @Override
    public Profile listId(int id) {
        return repository.findById(id).orElse(new Profile());
    }

    @Override
    public void update(Profile profile) {
        repository.save(profile);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override public int updateLinkedIn(Integer userId, String linkedinUrl) {
        return repository.updateLinkedIn(userId, linkedinUrl);
    }
}
