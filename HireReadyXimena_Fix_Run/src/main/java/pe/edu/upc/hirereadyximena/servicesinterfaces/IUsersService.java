package pe.edu.upc.hirereadyximena.servicesinterfaces;

import pe.edu.upc.hirereadyximena.entities.Users;
import java.util.List;

public interface IUsersService {
    void insert(Users user);
    List<Users> list();
    Users listId(int id);
    void update(Users user);
    void delete(int id);
    Users login(String email, String passwordHash);
    int assignRole(Integer userId, Integer roleId);
    int updatePersonalData(Integer userId, String firstName, String lastName, String languagePref);
    int updateProfilePicture(Integer userId, String url);
    int verifyUser(Integer userId);
    int softDeleteUser(Integer userId);
    int updateLanguage(Integer userId, String languagePref);
    int completeOnboarding(Integer userId);
    int recoverPassword(String email, String passwordHash);
}
