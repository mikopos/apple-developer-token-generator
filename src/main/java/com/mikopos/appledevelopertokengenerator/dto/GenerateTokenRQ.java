package com.mikopos.appledevelopertokengenerator.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateTokenRQ implements Serializable {

  private String teamId;
  private String keyId;
  private String secret;
}
