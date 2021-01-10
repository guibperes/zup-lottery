package br.com.zup.lottery.api.bet;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.zup.lottery.api.user.LotteryUser;
import br.com.zup.lottery.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
public class Bet extends BaseEntity {

  @NotNull
  @OneToOne
  @JoinColumn(updatable = false)
  private LotteryUser user;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
  @JoinColumn(name = "bet_id", updatable = false, nullable = false)
  @Builder.Default
  private Set<BetNumber> numbers = new HashSet<>();

  @NotNull
  @Min(1)
  private Integer size;
}
