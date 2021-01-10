package br.com.zup.lottery.api.bet;

import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.lottery.api.bet.dto.BetDTO;
import br.com.zup.lottery.base.annotations.RestConfig;
import br.com.zup.lottery.base.exceptions.BadRequestException;
import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestConfig
@Api(tags = "Bet")
@RequestMapping("/bets")
public class BetController {

  @Autowired
  private BetService service;

  @PostMapping
  public ResponseEntity<Void> save(
    @RequestBody @Valid BetDTO betDTO,
    @ApiIgnore Errors errors
  ) {
    if (errors.hasErrors()) {
      throw new BadRequestException(errors.getFieldErrors());
    }

    var id = service.save(betDTO);
    var location = ServletUriComponentsBuilder.fromCurrentContextPath()
      .path("/bets/")
      .path(id.toString())
      .build()
      .toUri();

    return ResponseEntity
      .created(location)
      .build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Bet> findById(@PathVariable UUID id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<Bet>> search(
    @RequestParam(required = false) Optional<String> email
  ) {
    return ResponseEntity.ok(service.search(email));
  }
}
