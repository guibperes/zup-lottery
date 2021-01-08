package br.com.zup.lottery.api.user;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.lottery.api.user.dto.LotteryUserDTO;
import br.com.zup.lottery.base.annotations.RestConfig;
import br.com.zup.lottery.base.exceptions.BadRequestException;
import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestConfig
@Api(tags = "LotteryUser")
@RequestMapping("/lotteryusers")
public class LotteryUserController {

  @Autowired
  private LotteryUserService service;

  @PostMapping
  public ResponseEntity<Void> save(
    @RequestBody @Valid LotteryUserDTO lotteryUserDTO,
    @ApiIgnore Errors errors
  ) {
    if (errors.hasErrors()) {
      throw new BadRequestException(errors.getFieldErrors());
    }

    var id = service.save(lotteryUserDTO);
    var location = ServletUriComponentsBuilder.fromCurrentContextPath()
      .path("/lotteryusers/")
      .path(id.toString())
      .build()
      .toUri();

    return ResponseEntity
      .created(location)
      .build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<LotteryUser> findById(@PathVariable UUID id) {
    return ResponseEntity.ok(service.findById(id));
  }
}
