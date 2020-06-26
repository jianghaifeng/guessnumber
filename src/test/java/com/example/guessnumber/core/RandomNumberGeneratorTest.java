package com.example.guessnumber.core;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomNumberGeneratorTest {
  RandomNumberGenerator generator = new RandomNumberGenerator();

  @Test
  public void shouldGenerateNumberWith4Charactors() {
    String generatedStr = generator.generate();
    assertEquals(generatedStr.length(), 4);
  }

  @Test
  public void shouldGenerateNumberWithDigits() {
    String generatedStr = generator.generate();
    for (char c:
        generatedStr.toCharArray()) {
      assertEquals(true, Character.isDigit(c));
    }
  }

  @Test
  @RepeatedTest(10)
  public void shouldGenerateNumberWithDistinctDigits() {
    String generatedStr = generator.generate();
    HashSet<Character> chars  = new HashSet<Character>();
    for (char c:
        generatedStr.toCharArray()) {
      chars.add(Character.valueOf(c));
    }
    assertEquals(chars.size(), generatedStr.length());
  }
}