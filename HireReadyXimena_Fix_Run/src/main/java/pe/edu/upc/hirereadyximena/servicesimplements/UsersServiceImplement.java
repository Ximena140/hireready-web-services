package pe.edu.upc.hirereadyximena.servicesimplements;

import pe.edu.upc.hirereadyximena.entities.Users;
import pe.edu.upc.hirereadyximena.repositories.IUserRepository;
import pe.edu.upc.hirereadyximena.servicesinterfaces.IUsersService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsersServiceImplement implements IUsersService {
    private final IUserRepository repository;

    public UsersServiceImplement(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(Users user) {
        repository.save(user);
    }

    @Override
    public List<Users> list() {
        return repository.findAll();
    }

    @Override
    public Users listId(int id) {
        return repository.findById(id).orElse(new Users());
    }

    @Override
    public void update(Users user) {
        repository.save(user);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override public Users login(String email, String passwordHash) {
        return repository.findByEmailAndPasswordHashAndIsDeletedFalse(email, passwordHash).orElseThrow();
    }

    @Override public int assignRole(Integer userId, Integer roleId) {
        return repository.assignRole(userId, roleId);
    }

    @Override public int updatePersonalData(Integer userId, String firstName, String lastName, String languagePref) {
        return repository.updatePersonalData(userId, firstName, lastName, languagePref);
    }

    @Override public int updateProfilePicture(Integer userId, String url) {
        return repository.updateProfilePicture(userId, url);
    }

    @Override public int verifyUser(Integer userId) {
        return repository.verifyUser(userId);
    }

    @Override public int softDeleteUser(Integer userId) {
        return repository.softDeleteUser(userId);
    }

    @Override public int updateLanguage(Integer userId, String languagePref) {
        return repository.updateLanguage(userId, languagePref);
    }

    @Override public int completeOnboarding(Integer userId) {
        return repository.completeOnboarding(userId);
    }

    @Override public int recoverPassword(String email, String passwordHash) {
        return repository.updatePasswordByEmail(email, passwordHash);
    }
}
