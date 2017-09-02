package mx.com.dxesoft.sirefi2.repository;

import mx.com.dxesoft.sirefi2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * sirefi2, mx.com.dxesoft.sirefi2.repository . UserRepository
 * Created by ernesto on 31/08/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by it's user name
     * @return the user.
     */
    User findUserByEmail(String email);

    List<User> findAll();
}
