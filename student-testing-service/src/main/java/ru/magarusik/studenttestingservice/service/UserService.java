package ru.magarusik.studenttestingservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.magarusik.studenttestingservice.dto.UserDTO;
import ru.magarusik.studenttestingservice.repository.UserRepository;
import ru.magarusik.studenttestingservice.utils.Converter;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(Converter::userToUserDTO).toList();
    }
}
