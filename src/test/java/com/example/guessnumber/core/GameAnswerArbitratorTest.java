package com.example.guessnumber.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GameAnswerArbitratorTest {
  @Test
  public void shouldReturn4A0BWhenAllNumbersAreCorrect() {
    GameAnswerArbitrator arbitrator = new GameAnswerArbitrator();
    GameAnswer target = new GameAnswer("1234");
    GameAnswer answer = new GameAnswer("1234");

    assertEquals("4A0B", arbitrator.check(target, answer));
  }

  @Test
  public void shouldReturn2A0BWhenOnly2NumbersAreCorrect() {
    GameAnswerArbitrator arbitrator = new GameAnswerArbitrator();
    GameAnswer target = new GameAnswer("1234");
    GameAnswer answer = new GameAnswer("1256");

    assertEquals("2A0B", arbitrator.check(target, answer));
  }

  @Test
  public void shouldReturn2A1BWhen2NumbersAreCorrectAnd1NumberWrongPosition() {
    GameAnswerArbitrator arbitrator = new GameAnswerArbitrator();
    GameAnswer target = new GameAnswer("1234");
    GameAnswer answer = new GameAnswer("1248");

    assertEquals("2A1B", arbitrator.check(target, answer));
  }
}