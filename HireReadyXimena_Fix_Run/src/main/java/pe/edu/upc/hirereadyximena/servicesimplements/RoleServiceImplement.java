package pe.edu.upc.hirereadyximena.servicesimplements;

import pe.edu.upc.hirereadyximena.entities.Role;
import pe.edu.upc.hirereadyximena.repositories.IRoleRepository;
import pe.edu.upc.hirereadyximena.servicesinterfaces.IRoleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    private final IRoleRepository repository;

    public RoleServiceImplement(IRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(Role role) {
        repository.save(role);
    }

    @Override
    public List<Role> list() {
        return repository.findAll();
    }

    @Override
    public Role listId(int id) {
        return repository.findById(id).orElse(new Role());
    }

    @Override
    public void update(Role role) {
        repository.save(role);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

}
