package com.example.guessnumber.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameAnswerTest {
  @Test
  public void shouldReturn4A0BWhenAllNumbersAreCorrect() {
    GameAnswer target = new GameAnswer("1234");
    GameAnswer answer = new GameAnswer("1234");

    assertEquals("4A0B", target.arbitrate(answer).toString());
  }

  @Test
  public void shouldReturn2A0BWhenOnly2NumbersAreCorrect() {

    GameAnswer target = new GameAnswer("1234");
    GameAnswer answer = new GameAnswer("1256");

    assertEquals("2A0B", target.arbitrate(answer).toString());
  }

  @Test
  public void shouldReturn2A1BWhen2NumbersAreCorrectAnd1NumberWrongPosition() {
    GameAnswer target = new GameAnswer("1234");
    GameAnswer answer = new GameAnswer("1248");

    assertEquals("2A1B", target.arbitrate(answer).toString());
  }

  @Test
  public void shouldNotValidWhenTheGuessIsNot4CharactorsLong() {
    GameAnswer answer = new GameAnswer("12345");

    assertEquals(false, answer.validate());
  }

  @Test
  public void shouldNotValidWhenThereIsRepeatedNumbers() {
    GameAnswer answer = new GameAnswer("1231");

    assertEquals(false, answer.validate());
  }

  @Test
  public void shouldNotValidWhenThereIsNonDigitCharactor() {
    GameAnswer answer = new GameAnswer("1a23");
    assertEquals(false, answer.validate());
  }

  @Test
  public void shouldBeValidWhenTheNumberIsValid() {
    GameAnswer answer = new GameAnswer("1234");
    assertEquals(true, answer.validate());
  }
}