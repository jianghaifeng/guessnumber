package com.example.guessnumber.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameTest {

  @Mock
  RandomAnswerGenerator generator;

  @Test
  public void shouldGenerateNumberWhenGameCeated() {
    GameAnswer target = new GameAnswer("1234");
    when(generator.generate()).thenReturn(target);

    Game game = new Game(generator);

    assertEquals(target, game.getTarget());
  }
}