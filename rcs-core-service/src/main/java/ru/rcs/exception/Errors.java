package ru.rcs.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Errors {

    MISSING_REQUIRED_PARAM_SCHOOL_CLASS_ID(120, "Missing required param school class id"),
    SCHOOL_CLASS_NOT_FOUND_BY_ID(121, "%s"),
    SCHOOL_CLASS_HAS_LINKED_TESTS(122, "%s"),

    MISSING_REQUIRED_PARAM_SUBJECT_ID(140, "Missing required param subject id"),
    SUBJECT_NOT_FOUND_BY_ID(141, "%s"),
    SUBJECT_HAS_LINKED_TESTS(142, "%s"),

    MISSING_REQUIRED_PARAM_SCHOOL_TEST_ID(160, "Missing required param school test id"),
    SCHOOL_TEST_NOT_FOUND_BY_ID(161, "%s"),

    OBJECT_SERIALIZATION_ERROR(1001, "%s"),
    OBJECT_DESERIALIZATION_ERROR(1002, "%s");

    private final Integer code;
    private final String message;
}
