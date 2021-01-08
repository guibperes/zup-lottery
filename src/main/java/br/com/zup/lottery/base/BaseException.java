package br.com.zup.lottery.base;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
@JsonIgnoreProperties({"cause", "localizedMessage", "stackTrace", "suppressed"})
public abstract class BaseException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final LocalDateTime timestamp = LocalDateTime.now();
  private Integer status;
  private String error;

  public BaseException(String message, HttpStatus httpStatus) {
    super(message);

    this.status = httpStatus.value();
    this.error = httpStatus.getReasonPhrase();
  }
}
