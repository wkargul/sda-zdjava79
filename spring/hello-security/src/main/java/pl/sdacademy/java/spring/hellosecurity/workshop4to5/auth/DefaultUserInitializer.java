package pl.sdacademy.java.spring.hellosecurity.workshop4to5.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sdacademy.java.spring.hellosecurity.workshop4to5.user.User;
import pl.sdacademy.java.spring.hellosecurity.workshop4to5.user.UserService;

import javax.annotation.PostConstruct;

@Component
public class DefaultUserInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DefaultUserInitializer.class);

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final String username;
    private final String password;

    public DefaultUserInitializer(
            UserService userService,
            PasswordEncoder passwordEncoder,
            @Value("${spring.security.user.name:admin}") String username,
            @Value("${spring.security.user.password:admin}") String password
    ) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.username = username;
        this.password = password;
    }

    @PostConstruct
    public void initDefaultUser() {
        final User user = new User();
        user.setUsername(username);
        user.setEncodedPassword(passwordEncoder.encode(password));
        userService.addUser(user).ifPresent(u ->
            logger.info("Utworzono użytkownika {}", username)
        );
    }
}
