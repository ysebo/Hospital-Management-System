package kg.alatoo.database.repository;

import jakarta.validation.constraints.NotEmpty;
import kg.alatoo.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u where u.email = :email")
    Optional<User> findByEmail(@Param("email")String email);

    @Query("SELECT u FROM User u WHERE u.phoneNumber = :phoneNumber")
    Optional<Object> findByPhoneNumber( String phoneNumber);
}
