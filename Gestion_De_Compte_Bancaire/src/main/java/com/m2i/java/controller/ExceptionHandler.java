package com.m2i.java.controller;

import com.m2i.java.DTO.ExceptionDto;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;

import static org.slf4j.LoggerFactory.getLogger;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionHandler {

    private static final Logger logger = getLogger(ExceptionHandler.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler({ RuntimeException.class, ApplicationContextException.class })
    public ExceptionDto handleRuntimeException(RuntimeException exception) {
        logger.error("Erreur inattendue", exception);
        return new ExceptionDto(exception);
    }

    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler({ IllegalArgumentException.class })
    public ExceptionDto handleIllegalArgumentException(RuntimeException exception) {
        logger.error("Argument invalide", exception);
        return new ExceptionDto(exception);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler({ ConstraintViolationException.class, MethodArgumentNotValidException.class })
    public ExceptionDto handleConstraintViolation(Exception exception) {
        logger.error("Erreur de validation", exception);
        return new ExceptionDto(exception, true);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ExceptionDto handleEntityNotFoundException(EntityNotFoundException exception) {
        logger.error("Donnée non trouvée", exception);
        return new ExceptionDto(exception);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(AccessDeniedException.class)
    public ExceptionDto handleAccessDeniedException(AccessDeniedException exception) {
        logger.error("Accès non autorisé à la ressource", exception);
        return new ExceptionDto(exception);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalStateException.class)
    public ExceptionDto handleMsIllegalStateException(IllegalStateException exception) {
        logger.error(exception.getMessage(), exception);
        return new ExceptionDto(exception);
    }

}
