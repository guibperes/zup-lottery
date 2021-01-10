package br.com.zup.lottery.api.bet;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zup.lottery.api.bet.dto.BetDTO;
import br.com.zup.lottery.api.user.LotteryUserService;
import br.com.zup.lottery.base.annotations.TransactionalService;
import br.com.zup.lottery.base.exceptions.EntityNotFoundedException;

@TransactionalService
public class BetService {

  @Autowired
  private BetRepository repository;

  @Autowired
  private LotteryUserService lotteryUserService;

  private Set<BetNumber> generateRandomBetNumbers(Integer size) {
    var random = new Random();

    return IntStream.range(0, size)
      .map(value -> random.nextInt(60) + 1)
      .mapToObj(value -> BetNumber.builder().number(value).build())
      .collect(Collectors.toSet());
  }

  public UUID save(BetDTO betDTO) {
    var lotteryUser = lotteryUserService.findByEmail(betDTO.getEmail());

    var bet = Bet.builder()
      .user(lotteryUser)
      .numbers(generateRandomBetNumbers(betDTO.getQuantity()))
      .size(betDTO.getQuantity())
      .build();

    var savedBet = repository.save(bet);
    return savedBet.getId();
  }

  public Bet findById(UUID id) {
    return repository
      .findById(id)
      .orElseThrow(() -> new EntityNotFoundedException("Cannot find Bet with provided id"));
  }

  public List<Bet> search(Optional<String> emailOptional) {
    if (emailOptional.isEmpty()) {
      return repository.findAll();
    }

    var lotteryUser = lotteryUserService.findByEmail(emailOptional.get());

    return repository.findByUserOrderByCreatedAtAsc(lotteryUser);
  }
}
