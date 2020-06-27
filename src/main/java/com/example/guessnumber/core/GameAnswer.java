package com.example.guessnumber.core;

import java.util.HashSet;

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
    HashSet<Character> chars = new HashSet<Character>();
    for (char c : answer.toCharArray()) {
      if (Character.isDigit(c)) {
        chars.add(Character.valueOf(c));
      }
    }
    if (chars.size() != DIGITS) {
      return false;
    }
    return true;
  }
}
