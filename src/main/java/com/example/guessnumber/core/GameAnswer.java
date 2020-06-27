package com.example.guessnumber.core;

public class GameAnswer {
  private String answer;
  private static final int DIGITS = 4;

  public GameAnswer(String answer) {
    this.answer = answer;
  }

  public String getAnswer() {
    return answer;
  }

  static public int getDIGITS() {
    return DIGITS;
  }

  public GameResult arbitrate(GameAnswer candidate) {
    int aQualified = 0, bQualified = 0;

    String candidateStr = candidate.getAnswer();

    for (int i = 0; i < DIGITS; i++) {
      if (candidateStr.charAt(i) == answer.charAt(i)) {
        aQualified++;
      } else if (answer.indexOf(candidateStr.charAt(i)) != -1) {
        bQualified++;
      }
    }

    return new GameResult(aQualified, bQualified);
  }

  public boolean validate() {
    if (answer.length() != DIGITS) {
      return false;
    }

    long digits = answer.chars()
        .mapToObj(i -> (char)i)
        .filter(Character::isDigit)
        .distinct()
        .count();

    if (digits != DIGITS) {
      return false;
    }
    return true;
  }
}
