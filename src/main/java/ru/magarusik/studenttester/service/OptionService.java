package ru.magarusik.studenttester.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.magarusik.studenttester.entity.Option;
import ru.magarusik.studenttester.repository.OptionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class OptionService {
    private final OptionRepository optionRepository;

    public List<Option> getAllOptions() {
        return optionRepository.findAll();
    }

    public Option getOptionByID(long id) {
        return optionRepository.getReferenceById(id);
    }

    public List<Option> getOptionsByQuestionID(long id) {
        return optionRepository.getOptionsByQuestionId(id);
    }

    public Option createOption(Option option) {
        return optionRepository.save(option);
    }

    public Option updateOption(Option option) {
        return optionRepository.save(option);
    }

    public void deleteOption(long id) {
        optionRepository.deleteById(id);
    }
}
