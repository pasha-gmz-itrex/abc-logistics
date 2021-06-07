package com.abc.logistics.controllers.handlers;

import static java.util.stream.Collectors.toList;

import com.abc.logistics.dto.models.errors.InvalidRequestDetails;
import com.abc.logistics.dto.models.errors.InvalidRequestError;
import com.abc.logistics.dto.models.errors.UnexpectedServerError;
import com.abc.logistics.exceptions.ForbiddenServerException;
import com.abc.logistics.exceptions.InvalidRequestException;
import com.abc.logistics.exceptions.InvalidRequestExceptionDetails;
import com.abc.logistics.exceptions.ItemNotFoundException;
import com.abc.logistics.exceptions.UnauthorizedServerException;
import com.abc.logistics.exceptions.UnexpectedServerException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String INTERNAL_SERVER_ERROR_MESSAGE =
        "Unexpected internal server error.";

    private static final String REQUEST_VALIDATION_FAILED_MESSAGE =
        "Request validation failed.";

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<UnexpectedServerError> globalExceptionHandler(Exception ex) {
        log.error("Unhandled exception occurred.", ex);
        return new ResponseEntity<>(
            new UnexpectedServerError(INTERNAL_SERVER_ERROR_MESSAGE),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler({UnexpectedServerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<UnexpectedServerError> handleUnexpectedError(UnexpectedServerException ex) {
        log.error("Unhandled exception occurred.", ex);
        return new ResponseEntity<>(
            new UnexpectedServerError(INTERNAL_SERVER_ERROR_MESSAGE),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler({InvalidRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<InvalidRequestError> handleInvalidRequest(InvalidRequestException ex) {
        List<InvalidRequestExceptionDetails> details = ex.getDetails();
        List<InvalidRequestDetails> errorDetails = CollectionUtils.isEmpty(details)
            ? List.of()
            : details.stream().map(it -> new InvalidRequestDetails(it.getField(), it.getMessage())).collect(toList());

        return new ResponseEntity<>(
            new InvalidRequestError(REQUEST_VALIDATION_FAILED_MESSAGE, errorDetails),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler({ItemNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<?> handleItemNotFoundError(ItemNotFoundException ex) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ForbiddenServerException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    protected ResponseEntity<?> handleForbiddenError(ForbiddenServerException ex) {
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({UnauthorizedServerException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    protected ResponseEntity<?> handleUnauthorizedError(UnauthorizedServerException ex) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
