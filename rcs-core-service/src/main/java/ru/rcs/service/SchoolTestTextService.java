package ru.rcs.service;

import ru.rcs.dto.SchoolTestTextDTO;

import java.util.UUID;
import ru.rcs.entity.SchoolTest;
import ru.rcs.entity.SchoolTestText;

public interface SchoolTestTextService {
    SchoolTestTextDTO create(SchoolTest schoolTest, SchoolTestTextDTO schoolTestTextDTO);
    SchoolTestTextDTO modify(UUID schoolTestTextId, SchoolTestTextDTO schoolTestTextDTO);
    void remove(UUID schoolTestTextId);

}
