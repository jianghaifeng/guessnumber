package com.example.guessnumber.core;

import java.util.Random;

public class RandomAnswerGenerator {
  Random random;

  public RandomAnswerGenerator(Random random) {
    this.random = random;
  }

  public RandomAnswerGenerator() {
    random = new Random();
  }

  public GameAnswer generate() {
    String str = "";

    while (str.length() < GameAnswer.getDIGITS()) {
      char ch = (char) (random.nextInt(10) + '0');
      if (str.length() == 0 || str.indexOf(ch) == -1) {
        str += String.valueOf(ch);
      }
    }

    return new GameAnswer(str);
  }
}
