package ru.rcs.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Errors {

    SCHOOL_CLASS_NOT_FOUND_BY_ID(121, "%s"),

    SUBJECT_NOT_FOUND_BY_ID(141, "%s"),

    MISSING_REQUIRED_PARAM_SCHOOL_TEST_ID(160, "Missing required param school test id"),
    SCHOOL_TEST_FOUND_BY_ID(161, "%s");

    private final Integer code;
    private final String message;
}
