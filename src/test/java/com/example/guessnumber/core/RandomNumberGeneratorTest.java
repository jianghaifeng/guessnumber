package com.example.guessnumber.core;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RandomNumberGeneratorTest {
  @Mock
  Random mockRandom;

  @InjectMocks
  RandomNumberGenerator generatorWithMockRandom;

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

  @Test
  public void shouldGenerateRamdomNumbers() {
    when(mockRandom.nextInt(10))
        .thenReturn(2)
        .thenReturn(5)
        .thenReturn(3)
        .thenReturn(8);

    assertEquals("2538", generatorWithMockRandom.generate());
  }
}