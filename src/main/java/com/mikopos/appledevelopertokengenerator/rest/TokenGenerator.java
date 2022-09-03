package com.mikopos.appledevelopertokengenerator.rest;

import com.mikopos.appledevelopertokengenerator.dto.GenerateTokenRQ;
import com.mikopos.appledevelopertokengenerator.services.GenerateTokenService;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenGenerator {

  private final GenerateTokenService generateTokenService;

  public TokenGenerator(GenerateTokenService generateTokenService) {
    this.generateTokenService = generateTokenService;
  }

  @PostMapping(value = "/generate", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  private String generate(GenerateTokenRQ generateTokenRQ)
      throws NoSuchAlgorithmException, InvalidKeySpecException {
    return generateTokenService.generate(generateTokenRQ.getTeamId(), generateTokenRQ.getKeyId(),
        generateTokenRQ.getSecret());
  }
}
