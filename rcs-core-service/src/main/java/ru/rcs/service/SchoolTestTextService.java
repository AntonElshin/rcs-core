package ru.rcs.service;

import ru.rcs.dto.SchoolTestTextDTO;
import ru.rcs.entity.SchoolTestText;

public interface SchoolTestTextService {

    SchoolTestText add(SchoolTestTextDTO schoolTestTextDTO);

}
