package ru.magarusik.client.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.magarusik.client.controller.payload.NewUserPayload;
import ru.magarusik.client.entity.Authority;
import ru.magarusik.client.entity.User;
import ru.magarusik.client.repository.AuthorityRepository;
import ru.magarusik.client.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(user -> org.springframework.security.core.userdetails.User.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .authorities(user.getAuthorities().stream()
                                .map(Authority::getName)
                                .map(SimpleGrantedAuthority::new)
                                .toList())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("User %s not found".formatted(username)));
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void createUser(NewUserPayload payload) {
        var user = User.builder()
                .username(payload.username())
                .password(passwordEncoder.encode(payload.password()))
                .authorities(List.of(authorityRepository
                        .findByName(payload.authority())))
                .build();
        userRepository.save(user);
    }

    public User findUseByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User %s not found".formatted(username)));
    }
}
