package ru.magarusik.studenttester.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.magarusik.studenttester.entity.UserEntity;
import ru.magarusik.studenttester.repository.UserEntityRepository;
import ru.magarusik.studenttester.security.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserEntity> getAllUsers() {
        return userEntityRepository.findAll();
    }



    public List<UserEntity> getAllTeachers() {
        return userEntityRepository.findAll()
                .stream()
                .filter(user -> "Преподаватель".equals(user.getRole().getName()))
                .toList();
    }

    public void saveUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntityRepository.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userEntityRepository.findUserEntitiesByUsername(username);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", username));
        }

        return new User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                new HashSet<>()
        );
    }


}
