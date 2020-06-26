package com.example.guessnumber.core;

public class GameAnswer {
  private String answer;

  public GameAnswer(String answer) {
    this.answer = answer;
  }

  public String getAnswer() {
    return answer;
  }

  public String arbitrate(GameAnswer candidate) {
    String candidateStr = candidate.getAnswer();

    int aQualified = 0, bQualified = 0;

    for (int i = 0; i < 4; i++) {
      if (candidateStr.charAt(i) == answer.charAt(i)) {
        aQualified++;
      } else if (answer.indexOf(candidateStr.charAt(i)) != -1) {
        bQualified++;
      }
    }
    return String.format("%dA%dB", aQualified, bQualified);
  }

  public boolean validate() {
    return true;
  }
}
