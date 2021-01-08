package br.com.zup.lottery.base.exceptions;

import org.springframework.http.HttpStatus;

import br.com.zup.lottery.base.BaseException;

public class EntityExistsException extends BaseException {

  private static final long serialVersionUID = 1L;

  public EntityExistsException(String message) {
    super(message, HttpStatus.CONFLICT);
  }
}
