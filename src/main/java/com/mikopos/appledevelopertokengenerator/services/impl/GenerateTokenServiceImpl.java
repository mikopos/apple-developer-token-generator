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

  private static final String ALG = "alg";
  private static final String KID = "kid";
  private static final String ISS = "iss";
  private static final String IAT = "iat";
  private static final String EXP = "exp";
  private static final int SECONDS_TO_ADD = 5184000; // 60 days

  @Override
  public String generate(String teamId, String keyId, String secret)
      throws NoSuchAlgorithmException, InvalidKeySpecException {

    var privateKey = JwtUtil.getEcPrivateKey(secret);
    Algorithm algorithm = Algorithm.ECDSA256(null, privateKey);
    Map<String, Object> headers = new HashMap<>();
    headers.put(ALG, algorithm.getName());
    headers.put(KID, keyId);

    return JWT.create()
        .withHeader(headers)
        .withClaim(ISS, teamId)
        .withClaim(IAT, Instant.now().getEpochSecond())
        .withClaim(EXP, Instant.now().plusSeconds(SECONDS_TO_ADD).getEpochSecond())
        .sign(algorithm);
  }
}
