package com.example.guessnumber.core;

import java.util.HashSet;

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
    if (answer.length() != 4) {
      return false;
    }
    HashSet<Character> chars = new HashSet<Character>();
    for (char c : answer.toCharArray()) {
      chars.add(Character.valueOf(c));
    }
    if (chars.size() != 4) {
      return false;
    }
    return true;
  }
}
