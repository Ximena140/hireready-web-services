package pe.edu.upc.hirereadyximena.repositories;

import pe.edu.upc.hirereadyximena.entities.Profile;
import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

public interface IProfileRepository extends JpaRepository<Profile, Integer> {
    Optional<Profile> findByUserUserId(Integer userId);

    // US08 Vinculación de LinkedIn
    @Modifying @Transactional
    @Query("UPDATE Profile p " +
            "SET p.linkedinUrl = :linkedinUrl " +
            "WHERE p.user.userId = :userId")
    int updateLinkedIn(Integer userId, String linkedinUrl);
}
