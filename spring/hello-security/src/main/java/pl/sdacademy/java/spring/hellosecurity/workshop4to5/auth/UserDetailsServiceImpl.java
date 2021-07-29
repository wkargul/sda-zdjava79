package pl.sdacademy.java.spring.hellosecurity.workshop4to5.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sdacademy.java.spring.hellosecurity.workshop4to5.user.User;
import pl.sdacademy.java.spring.hellosecurity.workshop4to5.user.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userService.getUser(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new UserDetailsImpl(user);
    }
}
