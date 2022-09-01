package com.mikopos.appledevelopertokengenerator.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import org.springframework.http.ResponseEntity;

public interface GenerateTokenService {

  String generate(String teamId, String keyId, String secret)
      throws NoSuchAlgorithmException, InvalidKeySpecException;
}
