package ru.rcs.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rcs.dto.SchoolTestTextDTO;
import ru.rcs.entity.SchoolTestText;
import ru.rcs.entity.Subject;
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
    public SchoolTestTextDTO add(SchoolTestTextDTO schoolTestTextDTO) {
        SchoolTestText schoolTestText = schoolTestTextMapper.fromDto(schoolTestTextDTO);
        SchoolTestText addedSchoolTestText = schoolTestTextRepository.save(schoolTestText);
        return schoolTestTextMapper.toDto(addedSchoolTestText);
    }

    @Override
    public SchoolTestTextDTO modify(UUID schoolTestTextId, SchoolTestTextDTO schoolTestTextDTO) {
        SchoolTestText foundSchoolTestText = schoolTestTextRepository.getById(String.valueOf(schoolTestTextId));

        if(schoolTestTextDTO.getHeader() != null) {
            foundSchoolTestText.setHeader(schoolTestTextDTO.getHeader());
        }
        if(schoolTestTextDTO.getText() != null) {
            foundSchoolTestText.setText(schoolTestTextDTO.getText());
        }

        SchoolTestText modifiedSchoolTestText = schoolTestTextRepository.save(foundSchoolTestText);
        return schoolTestTextMapper.toDto(modifiedSchoolTestText);
    }

    @Override
    @Transactional
    public void remove(UUID schoolTestTextId) {

        if(schoolTestTextId == null) {
            throw new BusinessException(Errors.MISSING_REQUIRED_PARAM_SCHOOL_TEST_TEXT_ID);
        }

        SchoolTestText schoolTestText = subjectRepository.findById(String.valueOf(schoolTestTextId))
                .orElseThrow(() -> new BusinessException(Errors.SCHOOL_TEST_TEXT_NOT_FOUND_BY_ID, schoolTestTextId));

        schoolTestTextRepository.deleteById(String.valueOf(schoolTestTextId));
    }
}
