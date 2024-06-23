package ru.magarusik.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.magarusik.service.dto.UserProfileDTO;
import ru.magarusik.service.entity.UserProfile;
import ru.magarusik.service.repository.UserProfileRepository;
import ru.magarusik.service.util.Converter;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserProfileRepository userProfileRepository;

    public List<UserProfileDTO> getAllUsers() {
        return userProfileRepository.findAll().stream()
                .map(Converter::convert)
                .toList();
    }

    public UserProfile createNewUserProfile(UserProfileDTO userProfileDTO) {
        return userProfileRepository.save(Converter.convert(userProfileDTO));
    }

    public UserProfileDTO getUserProfileByUserId(long userId) {
        return Converter.convert(userProfileRepository.getReferenceById(userId));
    }
}
