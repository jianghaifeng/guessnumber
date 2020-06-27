package com.example.guessnumber.core;

public class GameResult {
  private int aQualified;
  private int bQualified;

  public GameResult(int aQualified, int bQualified) {
    this.aQualified = aQualified;
    this.bQualified = bQualified;
  }

  @Override
  public String toString() {
    return String.format("%dA%dB", aQualified, bQualified);
  }

  public boolean isSuccess() {
    return aQualified == 4;
  }
}
