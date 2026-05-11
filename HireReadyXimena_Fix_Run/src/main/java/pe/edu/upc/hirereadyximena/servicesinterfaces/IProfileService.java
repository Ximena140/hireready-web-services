package pe.edu.upc.hirereadyximena.servicesinterfaces;

import pe.edu.upc.hirereadyximena.entities.Profile;
import java.util.List;

public interface IProfileService {
    void insert(Profile profile);
    List<Profile> list();
    Profile listId(int id);
    void update(Profile profile);
    void delete(int id);
    int updateLinkedIn(Integer userId, String linkedinUrl);
}
