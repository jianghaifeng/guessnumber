package com.example.guessnumber.core;

import java.util.Random;

public class RandomNumberGenerator {
  public String generate() {
    Random random = new Random();
    String str = "";
    for (int i = 0; i < 4; i++) {
      str += String.valueOf(random.nextInt(10));
    }
    return str;
  }
}
