package ru.magarusik.studenttestingclient.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.magarusik.studenttestingclient.controller.payload.NewUserPayload;
import ru.magarusik.studenttestingclient.entity.Authority;
import ru.magarusik.studenttestingclient.entity.User;
import ru.magarusik.studenttestingclient.repository.AuthorityRepository;
import ru.magarusik.studenttestingclient.repository.UserRepository;

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
                                .map(Authority::getAuthority)
                                .map(SimpleGrantedAuthority::new)
                                .toList())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("User %s not found".formatted(username)));
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void createUser(NewUserPayload payload) {
        User user = new User();
        user.setUsername(payload.getUsername());
        user.setPassword(passwordEncoder.encode(payload.getPassword()));
        user.setAuthorities(List.of(authorityRepository
                .findByAuthority(payload.getAuthority())));
        userRepository.save(user);
    }

    public User findUseByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User %s not found".formatted(username)));
    }
}
