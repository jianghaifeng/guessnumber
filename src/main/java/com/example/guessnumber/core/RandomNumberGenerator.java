package com.example.guessnumber.core;

import java.util.Random;

public class RandomNumberGenerator {
  Random random;

  public RandomNumberGenerator(Random random) {
    this.random = random;
  }

  public RandomNumberGenerator() {
    random = new Random();
  }

  public String generate() {
    String str = "";

    while (str.length() < 4) {
      char ch = (char) (random.nextInt(10) + '0');
      if (str.length() == 0 || str.indexOf(ch) == -1) {
        str += String.valueOf(ch);
      }
    }

    return str;
  }
}
