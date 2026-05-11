package pe.edu.upc.hirereadyximena.servicesinterfaces;

import pe.edu.upc.hirereadyximena.entities.Role;
import java.util.List;

public interface IRoleService {
    void insert(Role role);
    List<Role> list();
    Role listId(int id);
    void update(Role role);
    void delete(int id);
}
