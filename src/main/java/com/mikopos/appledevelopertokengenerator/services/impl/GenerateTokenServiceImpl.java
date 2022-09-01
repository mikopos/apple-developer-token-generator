package com.mikopos.appledevelopertokengenerator.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mikopos.appledevelopertokengenerator.services.GenerateTokenService;
import com.mikopos.appledevelopertokengenerator.utils.JwtUtil;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class GenerateTokenServiceImpl implements GenerateTokenService {

  @Override
  public String generate(String teamId, String keyId, String secret)
      throws NoSuchAlgorithmException, InvalidKeySpecException {

    var privateKey = JwtUtil.getEcPrivateKey(secret);
    Algorithm algorithm = Algorithm.ECDSA256(null, privateKey);
    Map<String, Object> headers = new HashMap<>();
    headers.put("alg", algorithm);
    headers.put("kid", keyId);

    String token = JWT.create()
        .withHeader(headers)
        .withClaim("iss", teamId)
        .withClaim("exp", Instant.now().getEpochSecond())
        .withClaim("iat", Instant.now().plusSeconds(43200).getEpochSecond())
        .sign(algorithm);

    return token;
  }
}
