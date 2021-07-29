package pl.sdacademy.java.spring.hellosecurity.workshop6to7.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String username) {
        return userRepository.findById(username);
    }

    @Transactional
    public Optional<User> addUser(User user) {
        if (userRepository.existsById(user.getUsername())) {
            return Optional.empty();
        } else {
            userRepository.save(user);
            return Optional.of(user);
        }
    }
}
