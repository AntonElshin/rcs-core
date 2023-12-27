package ru.rcs.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rcs.dto.SchoolTestTextDTO;
import ru.rcs.entity.SchoolTest;
import ru.rcs.entity.SchoolTestText;
import ru.rcs.exception.BusinessException;
import ru.rcs.exception.Errors;
import ru.rcs.mapper.SchoolTestTextMapper;
import ru.rcs.repository.SchoolTestTextRepository;
import ru.rcs.service.SchoolTestTextService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SchoolTestTextServiceImpl implements SchoolTestTextService {

    private final SchoolTestTextRepository schoolTestTextRepository;

    private final SchoolTestTextMapper schoolTestTextMapper;

    @Override
    @Transactional
    public SchoolTestTextDTO create(SchoolTest schoolTest, SchoolTestTextDTO schoolTestTextDTO) {
        SchoolTestText schoolTestText = schoolTestTextMapper.fromDto(schoolTestTextDTO);
        schoolTestText.setSchoolTest(schoolTest);
        schoolTestText = schoolTestTextRepository.save(schoolTestText);
        SchoolTestTextDTO createdSchoolTestTextDTO = schoolTestTextMapper.toDto(schoolTestText);
        createdSchoolTestTextDTO.setId(UUID.fromString(schoolTestText.getId()));
        return createdSchoolTestTextDTO;
    }

    @Override
    public SchoolTestTextDTO modify(UUID schoolTestTextId, SchoolTestTextDTO schoolTestTextDTO) {
        SchoolTestText schoolTestText = schoolTestTextRepository.getById(String.valueOf(schoolTestTextId));

        schoolTestText.setHeader(schoolTestTextDTO.getHeader());
        schoolTestText.setText(schoolTestTextDTO.getText());

        schoolTestText = schoolTestTextRepository.save(schoolTestText);
        SchoolTestTextDTO modifiedSchoolTestTextDTO = schoolTestTextMapper.toDto(schoolTestText);
        modifiedSchoolTestTextDTO.setId(UUID.fromString(schoolTestText.getId()));
        return modifiedSchoolTestTextDTO;
    }

    @Override
    @Transactional
    public void remove(UUID schoolTestTextId) {

        if(schoolTestTextId == null) {
            throw new BusinessException(Errors.MISSING_REQUIRED_PARAM_SCHOOL_TEST_TEXT_ID);
        }

        schoolTestTextRepository.findById(String.valueOf(schoolTestTextId))
                .orElseThrow(() -> new BusinessException(Errors.SCHOOL_TEST_TEXT_NOT_FOUND_BY_ID, schoolTestTextId));

        schoolTestTextRepository.deleteById(String.valueOf(schoolTestTextId));
    }
}
