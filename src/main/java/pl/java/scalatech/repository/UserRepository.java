package pl.java.scalatech.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByLogin(String login);
    Optional<User> findByEmail(String email);
    public Page<User> findByLoginStartsWith(String login, Pageable p);




}