package br.com.zup.lottery.api.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class LotteryUserDTO {

  @NotBlank
  @NotNull
  @Size(min = 3, max = 40)
  private String name;

  @NotBlank
  @NotNull
  @Email
  @Size(min = 3, max = 40)
  private String email;
}
