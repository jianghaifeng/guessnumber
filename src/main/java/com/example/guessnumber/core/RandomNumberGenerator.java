package com.example.guessnumber.core;

import java.util.Random;

public class RandomNumberGenerator {
  public String generate() {
    Random random = new Random();
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
