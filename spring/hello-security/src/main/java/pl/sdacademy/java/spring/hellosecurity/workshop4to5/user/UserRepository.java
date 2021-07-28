package pl.sdacademy.java.spring.hellosecurity.workshop4to5.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
