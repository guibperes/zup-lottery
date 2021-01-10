package br.com.zup.lottery.api.bet;

import java.util.List;

import br.com.zup.lottery.api.user.LotteryUser;
import br.com.zup.lottery.base.BaseRepository;

public interface BetRepository extends BaseRepository<Bet> {

  List<Bet> findByUserOrderByCreatedAtAsc(LotteryUser user);
}
