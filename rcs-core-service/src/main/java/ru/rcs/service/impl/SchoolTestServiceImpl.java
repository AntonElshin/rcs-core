package ru.rcs.service.impl;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rcs.dto.SchoolTestReqDTO;
import ru.rcs.dto.SchoolTestResDTO;
import ru.rcs.exception.BusinessException;
import ru.rcs.exception.Errors;
import ru.rcs.mapper.SchoolTestMapper;
import ru.rcs.repository.SchoolTestRepository;
import ru.rcs.service.SchoolTestService;

@Service
@RequiredArgsConstructor
public class SchoolTestServiceImpl implements SchoolTestService {

  private final SchoolTestRepository schoolTestRepository;

  private final SchoolTestMapper schoolTestMapper;

  @Override
  public List<SchoolTestReqDTO> find(String search) {
    return null;
  }

  @Override
  public SchoolTestResDTO getById(UUID schoolTestId) {

    if(schoolTestId == null) {
      throw new BusinessException(Errors.MISSING_REQUIRED_PARAM_SCHOOL_TEST_ID);
    }

    schoolTestRepository.findById(String.valueOf(schoolTestId)).orElseThrow(() -> new BusinessException(Errors.SCHOOL_TEST_FOUND_BY_ID, schoolTestId));

    return null;
  }

  @Override
  public SchoolTestResDTO add(SchoolTestReqDTO schoolTestReqDTO) {
    return null;
  }

  @Override
  public SchoolTestResDTO modify(UUID schoolTestId, SchoolTestReqDTO schoolTestReqDTO) {
    return null;
  }

  @Override
  public void remove(UUID schoolTestId) {

  }
}
