package br.com.zup.lottery.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(BaseException.class)
  public ResponseEntity<BaseException> handleBaseException(BaseException exception) {
    return ResponseEntity
      .status(exception.getStatus())
      .body(exception);
  }
}
