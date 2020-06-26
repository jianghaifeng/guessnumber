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
class RandomAnswerGeneratorTest {
  @Mock
  Random mockRandom;

  @InjectMocks
  RandomAnswerGenerator generatorWithMockRandom;

  RandomAnswerGenerator generator = new RandomAnswerGenerator();

  @Test
  @RepeatedTest(10)
  public void shouldGenerateValidAnswer() {
    GameAnswer answer = generator.generate();
    assertEquals(true, answer.validate());
  }

  @Test
  public void shouldGenerateRamdomNumbers() {
    when(mockRandom.nextInt(10))
        .thenReturn(2)
        .thenReturn(5)
        .thenReturn(3)
        .thenReturn(8);

    assertEquals("2538", generatorWithMockRandom.generate().getAnswer());
  }
}