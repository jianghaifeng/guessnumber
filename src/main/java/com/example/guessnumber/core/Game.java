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
    int aQualified = 0, bQualified = 0;

    for (int i = 0; i < 4; i++) {
      if (guessNumberStr.charAt(i) == targetNumberStr.charAt(i)) {
        aQualified++;
      } else if (targetNumberStr.indexOf(guessNumberStr.charAt(i)) != -1) {
        bQualified++;
      }
    }
    return String.format("%dA%dB", aQualified, bQualified);
  }
}
