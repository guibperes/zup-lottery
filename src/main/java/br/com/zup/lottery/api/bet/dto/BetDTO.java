package br.com.zup.lottery.api.bet.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class BetDTO {

  @NotBlank
  @NotNull
  @Email
  @Size(min = 3, max = 40)
  private String email;

  @NotNull
  @Min(1)
  @Max(60)
  private Integer quantity;
}
