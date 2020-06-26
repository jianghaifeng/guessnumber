package com.example.guessnumber.core;

public class GameAnswerArbitrator {

  public String check(GameAnswer target, GameAnswer candidate) {
    String targetStr =  target.getAnswer();
    String candidateStr = candidate.getAnswer();

    int aQualified = 0, bQualified = 0;

    for (int i = 0; i < 4; i++) {
      if (candidateStr.charAt(i) == targetStr.charAt(i)) {
        aQualified++;
      } else if (targetStr.indexOf(candidateStr.charAt(i)) != -1) {
        bQualified++;
      }
    }
    return String.format("%dA%dB", aQualified, bQualified);
  }
}
