package com.mikopos.appledevelopertokengenerator.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface GenerateTokenService {

  String generate(String teamId, String keyId, String secret)
      throws NoSuchAlgorithmException, InvalidKeySpecException;
}
