package com.example.guessnumber.core;

public class Game {
  private String targetNumberStr;

  public Game(RandomNumberGenerator generator) {
    this.targetNumberStr = generator.generate();
  }

  public String getTargetNumberStr() {
    return targetNumberStr;
  }
}
