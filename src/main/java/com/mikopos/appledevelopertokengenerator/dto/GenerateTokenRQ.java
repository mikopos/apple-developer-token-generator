package com.mikopos.appledevelopertokengenerator.dto;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GenerateTokenRQ implements Serializable {

  private String teamId;
  private String keyId;
  private String secret;
}
