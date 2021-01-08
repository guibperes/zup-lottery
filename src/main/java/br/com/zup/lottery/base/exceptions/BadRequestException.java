package br.com.zup.lottery.base.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import br.com.zup.lottery.base.BaseException;

public class BadRequestException extends BaseException {

  private static final long serialVersionUID = 1L;

  private static String fieldErrorsToString(List<FieldError> errors) {
    return errors.stream()
      .map(error -> error.getField() + " " + error.getDefaultMessage())
      .collect(Collectors.joining(", "));
  }

  public BadRequestException(String message) {
    super(message, HttpStatus.BAD_REQUEST);
  }

  public BadRequestException(List<FieldError> errors) {
    super(fieldErrorsToString(errors), HttpStatus.BAD_REQUEST);
  }
}
