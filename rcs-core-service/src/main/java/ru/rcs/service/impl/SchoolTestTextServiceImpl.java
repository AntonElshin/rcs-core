package ru.rcs.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rcs.dto.SchoolTestTextDTO;
import ru.rcs.entity.SchoolTestText;
import ru.rcs.mapper.SchoolTestTextMapper;
import ru.rcs.repository.SchoolTestTextRepository;
import ru.rcs.service.SchoolTestTextService;

@Service
@RequiredArgsConstructor
public class SchoolTestTextServiceImpl implements SchoolTestTextService {

    private final SchoolTestTextRepository schoolTestTextRepository;

    private final SchoolTestTextMapper schoolTestTextMapper;

    @Override
    @Transactional
    public SchoolTestText add(SchoolTestTextDTO schoolTestTextDTO) {
        return schoolTestTextRepository.save(schoolTestTextMapper.fromDto(schoolTestTextDTO));
    }
}
