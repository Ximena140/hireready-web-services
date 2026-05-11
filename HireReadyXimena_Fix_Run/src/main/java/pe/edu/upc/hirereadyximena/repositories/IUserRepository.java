package pe.edu.upc.hirereadyximena.repositories;

import pe.edu.upc.hirereadyximena.entities.Users;
import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<Users, Integer> {
    // US02 Inicio de sesión seguro
    Optional<Users> findByEmailAndPasswordHashAndIsDeletedFalse(String email, String passwordHash);

    Optional<Users> findByEmail(String email);

    // US55 Asignación de roles
    @Modifying @Transactional
    @Query("UPDATE Users u " +
            "SET u.role.roleId = :roleId " +
            "WHERE u.userId = :userId")
    int assignRole(Integer userId, Integer roleId);

    // US05 Edición de perfil personal
    @Modifying @Transactional
    @Query("UPDATE Users u " +
            "SET u.firstName = :firstName, u.lastName = :lastName, u.languagePref = :languagePref " +
            "WHERE u.userId = :userId")
    int updatePersonalData(Integer userId, String firstName, String lastName, String languagePref);

    // US06 Carga de foto de perfil
    @Modifying @Transactional
    @Query("UPDATE Users u " +
            "SET u.profilePictureUrl = :url " +
            "WHERE u.userId = :userId")
    int updateProfilePicture(Integer userId, String url);

    // US10 Validación de datos de registro
    @Modifying @Transactional
    @Query("UPDATE Users u " +
            "SET u.isVerified = true " +
            "WHERE u.userId = :userId")
    int verifyUser(Integer userId);

    // US11 Eliminación de cuenta
    @Modifying @Transactional
    @Query("UPDATE Users u " +
            "SET u.isDeleted = true " +
            "WHERE u.userId = :userId")
    int softDeleteUser(Integer userId);

    // US13 Preferencias de idioma
    @Modifying @Transactional
    @Query("UPDATE Users u " +
            "SET u.languagePref = :languagePref " +
            "WHERE u.userId = :userId")
    int updateLanguage(Integer userId, String languagePref);

    // US04 Onboarding guiado
    @Modifying @Transactional
    @Query("UPDATE Users u " +
            "SET u.onboardingDone = true " +
            "WHERE u.userId = :userId")
    int completeOnboarding(Integer userId);

    // US03 Recuperación de contraseña
    @Modifying @Transactional
    @Query("UPDATE Users u " +
            "SET u.passwordHash = :passwordHash " +
            "WHERE u.email = :email")
    int updatePasswordByEmail(String email, String passwordHash);
}
