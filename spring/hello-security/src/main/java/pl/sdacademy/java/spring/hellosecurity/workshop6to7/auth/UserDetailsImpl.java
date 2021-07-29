package pl.sdacademy.java.spring.hellosecurity.workshop6to7.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.sdacademy.java.spring.hellosecurity.workshop6to7.user.User;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final GrantedAuthority role = new SimpleGrantedAuthority("ROLE_" + user.getRole());

        List<GrantedAuthority> authorities = new LinkedList<>();
        authorities.add(role);

        //Jeżeli użytkownik jest w roli ADMIN lub READER, dodaj uprawnienie READ_USERS
        if ("ADMIN".equals(user.getRole()) || "READER".equals(user.getRole())) {
            authorities.add(new SimpleGrantedAuthority("READ_USERS"));
        }

        //Zwraca niemodyfikowalną kolekcję uprawnień (READ_USERS może tam być lub nie)
        return Collections.unmodifiableCollection(authorities);
    }

    @Override
    public String getPassword() {
        return user.getEncodedPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
