package com.mikopos.appledevelopertokengenerator.utils;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class JwtUtil {

  private static final String EC = "EC";
  private static final String BEGIN_PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----";
  private static final String END_PRIVATE_KEY = "-----END PRIVATE KEY-----";
  private static final String LINE_CHANGE = "\r\n";

  public static ECPrivateKey getEcPrivateKey(String secret)
      throws NoSuchAlgorithmException, InvalidKeySpecException {

    byte[] encoded = Base64.getDecoder().decode(secret.getBytes(StandardCharsets.UTF_8));
    KeyFactory kf = KeyFactory.getInstance(EC);
    EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
    return (ECPrivateKey) kf.generatePrivate(keySpec);
  }

  public static String transformPrivateKey(String secret) {
    return secret.replace(BEGIN_PRIVATE_KEY, "")
        .replace(END_PRIVATE_KEY, "")
        .replace(LINE_CHANGE,"");
  }
}
