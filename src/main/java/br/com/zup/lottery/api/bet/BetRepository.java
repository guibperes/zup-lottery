package br.com.zup.lottery.api.bet;

import java.util.List;

import javax.persistence.OrderBy;

import br.com.zup.lottery.api.user.LotteryUser;
import br.com.zup.lottery.base.BaseRepository;

public interface BetRepository extends BaseRepository<Bet> {

  @OrderBy("createdAt")
  List<Bet> findByUser(LotteryUser user);
}
