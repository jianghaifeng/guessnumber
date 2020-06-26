package com.example.guessnumber.core;

public class Game {
  private String targetNumberStr;

  public Game(RandomNumberGenerator generator) {
    this.targetNumberStr = generator.generate();
  }

  public String getTargetNumberStr() {
    return targetNumberStr;
  }

  public String guess(String guessNumberStr) {
    int aQulified = 0;

    for (int i = 0; i < 4; i++) {
      if (guessNumberStr.charAt(i) == targetNumberStr.charAt(i)) {
        aQulified++;
      }
    }
    return String.format("%dA0B", aQulified);
  }
}
