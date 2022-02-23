package ru.alexander_kramarenko.java_web_shop_v11.auth.repositories;

import org.springframework.web.bind.annotation.CrossOrigin;
import ru.alexander_kramarenko.java_web_shop_v11.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
