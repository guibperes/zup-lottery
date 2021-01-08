package br.com.zup.lottery.api.user;

import java.util.Optional;

import br.com.zup.lottery.base.BaseRepository;

public interface LotteryUserRepository extends BaseRepository<LotteryUser> {

  Optional<LotteryUser> findByEmail(String email);
}
