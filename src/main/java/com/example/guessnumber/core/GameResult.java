package com.example.guessnumber.core;

import java.util.Objects;

public class GameResult {
  private String result;

  public GameResult(String result) {
    this.result = result;
  }

  public GameResult(int aQualifier, int bQualifier) {
    this.result = String.format("%dA%dB", aQualifier, bQualifier);
  }

  public boolean isSuccess() {
    return "4A0B".equals(result);
  }

  public String getResult() {
    return result;
  }
}
