package br.com.zup.lottery.base.exceptions;

import org.springframework.http.HttpStatus;

import br.com.zup.lottery.base.BaseException;

public class EntityNotFoundedException extends BaseException {

  private static final long serialVersionUID = 1L;

  public EntityNotFoundedException(String message) {
    super(message, HttpStatus.NOT_FOUND);
  }
}
