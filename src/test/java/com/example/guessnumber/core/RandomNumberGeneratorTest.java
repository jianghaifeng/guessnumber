package com.example.guessnumber.core;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomNumberGeneratorTest {
  RandomNumberGenerator generator = new RandomNumberGenerator();

  @Test
  @RepeatedTest(10)
  public void shouldGenerateNumberWith4Charactors() {
    String generatedStr = generator.generate();
    assertEquals(generatedStr.length(), 4);
  }
}