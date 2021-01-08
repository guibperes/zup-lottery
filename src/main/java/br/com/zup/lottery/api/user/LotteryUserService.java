package br.com.zup.lottery.api.user;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zup.lottery.api.user.dto.LotteryUserDTO;
import br.com.zup.lottery.base.annotations.TransactionalService;
import br.com.zup.lottery.base.exceptions.EntityExistsException;
import br.com.zup.lottery.base.exceptions.EntityNotFoundedException;

@TransactionalService
public class LotteryUserService {

  @Autowired
  private LotteryUserRepository repository;

  public UUID save(LotteryUserDTO lotteryUserDTO) {
    var lotteryUserOptional = repository.findByEmail(lotteryUserDTO.getEmail());

    if (lotteryUserOptional.isPresent()) {
      throw new EntityExistsException("User already exists with provided email");
    }

    var lotteryUser = LotteryUser.of(lotteryUserDTO);
    var savedLotteryUser = repository.save(lotteryUser);

    return savedLotteryUser.getId();
  }

  public LotteryUser findById(UUID id) {
    return repository
      .findById(id)
      .orElseThrow(() -> new EntityNotFoundedException("Cannot find User with provided id"));
  }
}
