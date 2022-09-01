package com.mikopos.appledevelopertokengenerator.utils;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class JwtUtil {

  public static ECPrivateKey getEcPrivateKey(String secret)
      throws NoSuchAlgorithmException, InvalidKeySpecException {
    byte[] encoded = Base64.getDecoder().decode(secret);
    KeyFactory kf = KeyFactory.getInstance("EC");
    EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
    return (ECPrivateKey) kf.generatePrivate(keySpec);
  }
}
