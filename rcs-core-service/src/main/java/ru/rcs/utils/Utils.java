package ru.rcs.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ru.rcs.exception.BusinessException;
import ru.rcs.exception.Errors;
import ru.rcs.exception.MessagesConstant;

public class Utils {

    public static final String ROOT_PACKAGE_NAME = "ru.rcs";

    public static List<Long> getUniqueIds(List<Long> ids) {

        List<Long> uniqueIds = new ArrayList<>();

        for(int j=0; j<ids.size(); j++) {
            Long checkId = ids.get(j);

            Boolean foundFlag = false;

            for(Long uniqueId : uniqueIds) {
                if(uniqueId.equals(checkId)) {
                    foundFlag = true;
                    break;
                }
            }

            if(!foundFlag) {
                uniqueIds.add(Long.valueOf(checkId));
            }
        }

        return uniqueIds;

    }

    public static String receiveJSON(ObjectMapper objectMapper, Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new BusinessException(
                    Errors.OBJECT_SERIALIZATION_ERROR,
                    MessagesConstant.OBJECT_SERIALIZATION_ERROR,
                    object.getClass().getSimpleName()
            );
        }
    }

    public static <T> T mapFromJson(String json, Class<T> clazz, ObjectMapper objectMapper) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new BusinessException(
                    Errors.OBJECT_SERIALIZATION_ERROR,
                    MessagesConstant.OBJECT_DESERIALIZATION_ERROR,
                    clazz.getSimpleName()
            );
        }
    }

    public static <T> T mapFromJson(String json, TypeReference<T> type, ObjectMapper objectMapper) {
        try {
            return objectMapper.readValue(json, type);
        } catch (IOException e) {
            throw new BusinessException(
                    Errors.OBJECT_SERIALIZATION_ERROR,
                    MessagesConstant.OBJECT_DESERIALIZATION_ERROR,
                    type.getType().getTypeName()
            );
        }
    }

    public static String findRootCause(Throwable throwable) {
        Objects.requireNonNull(throwable);
        Throwable rootCause = throwable;
        while (rootCause.getCause() != null && rootCause.getCause() != rootCause) {
            rootCause = rootCause.getCause();
        }
        return rootCause.getMessage();
    }
}
