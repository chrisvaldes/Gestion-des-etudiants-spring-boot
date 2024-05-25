package projetjava.example.gestionEtudiants.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projetjava.example.gestionEtudiants.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query ("Select u from users u where u.email = :email")
    public User findByEmail(@Param("email") String email);
    @Query ("Select u from users u where u.email = :email and u.password = :password")
    public User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
*/