package com.nelioalves.workshopmongo.resources.exceptions;

import com.nelioalves.workshopmongo.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ControllerAdvice annotation allows you to handle
 * exceptions across the whole application, not just
 * for a specific controller.
 * <p>
 * HttpServletRequest is an interface that defines methods
 * to provide client request information to a servlet.
 */
@ControllerAdvice
public class ResourceExceptionHandler {
  /**
   * ExceptionHandler annotation allows you to handle
   * specific exceptions in specific methods.
   */
  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(
      ObjectNotFoundException e,
      HttpServletRequest request
  ) {
    String error = "Não encontrado";
    HttpStatus status = HttpStatus.NOT_FOUND;

    StandardError err = new StandardError(
        System.currentTimeMillis(),
        status.value(),
        error,
        e.getMessage(),
        request.getRequestURI()
    );

    return ResponseEntity.status(status).body(err);
  }
}