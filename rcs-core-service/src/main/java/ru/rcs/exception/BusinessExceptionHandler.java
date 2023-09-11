package ru.rcs.exception;

import static java.util.Objects.nonNull;
import static ru.rcs.utils.Utils.findRootCause;


import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.rcs.dto.ErrorDTO;
import ru.rcs.service.MessageService;


@RestControllerAdvice
@RequiredArgsConstructor
public class BusinessExceptionHandler {

    private final MessageService messageService;

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorDTO handleBusinessException(BusinessException businessException) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode((long) businessException.getCode());
        if (nonNull(businessException.getParameters()) && businessException.getParameters().length > 0) {
            errorDTO.setMessage(messageService.getLocalizedMessage(
                    businessException.getMessage(),
                    businessException.getParameters()));
        } else {
            errorDTO.setMessage(businessException.getMessage());
        }
        return errorDTO;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorDTO constraintViolationException(DataIntegrityViolationException exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(findRootCause(exception));
        errorDTO.setCode(-1L);
        return errorDTO;
    }
}
