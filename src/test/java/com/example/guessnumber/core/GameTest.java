package com.example.guessnumber.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameTest {

  @Mock
  RandomNumberGenerator generator;

  @Test
  public void shouldGenerateNumberWhenGameCeated() {
    when(generator.generate()).thenReturn("1234");

    Game game = new Game(generator);

    assertEquals("1234", game.getTargetNumberStr());
  }

  @Test
  public void shouldReturn4A0BWhenAllNumbersAreCorrect() {
    when(generator.generate()).thenReturn("1234");

    Game game = new Game(generator);

    assertEquals("4A0B", game.guess("1234"));
  }

  @Test
  public void shouldReturn2A0BWhenOnly2NumbersAreCorrect() {
    when(generator.generate()).thenReturn("1234");

    Game game = new Game(generator);

    assertEquals("2A0B", game.guess("1256"));
  }

  @Test
  public void shouldReturn2A1BWhen2NumbersAreCorrectAnd1NumberWrongPosition() {
    when(generator.generate()).thenReturn("1234");

    Game game = new Game(generator);

    assertEquals("2A1B", game.guess("1248"));
  }
}