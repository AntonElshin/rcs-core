package ru.rcs.service;

import ru.rcs.dto.SchoolTestTextDTO;

import java.util.UUID;

public interface SchoolTestTextService {

    SchoolTestTextDTO add(SchoolTestTextDTO schoolTestTextDTO);
    SchoolTestTextDTO modify(UUID schoolTestTextId, SchoolTestTextDTO schoolTestTextDTO);
    void remove(UUID schoolTestTextId);
}
