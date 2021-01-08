package br.com.zup.lottery.api.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zup.lottery.api.user.dto.LotteryUserDTO;
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
public class LotteryUser extends BaseEntity {

  @NotBlank
  @NotNull
  @Size(min = 3, max = 40)
  private String name;

  @NotBlank
  @NotNull
  @Email
  @Size(min = 3, max = 40)
  @Column(unique = true)
  private String email;

  public static LotteryUser of(LotteryUserDTO lotteryUserDTO) {
    return LotteryUser.builder()
      .name(lotteryUserDTO.getName())
      .email(lotteryUserDTO.getEmail())
      .build();
  }
}
