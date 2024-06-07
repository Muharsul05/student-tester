package ru.magarusik.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.magarusik.service.dto.UserDTO;
import ru.magarusik.service.repository.UserRepository;
import ru.magarusik.service.util.Converter;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(Converter::convert)
                .toList();
    }
}
