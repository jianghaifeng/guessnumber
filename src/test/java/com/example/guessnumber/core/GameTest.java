package com.example.guessnumber.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

  @Test
  public void shouldNotArbitrateWhenNumberIsInvalid() {
    GameAnswer target = new GameAnswer("1234");
    when(generator.generate()).thenReturn(target);

    Game game = new Game(generator);
    GameAnswer answer = mock(GameAnswer.class);

    when(answer.validate()).thenReturn(false);
    game.guess(answer);

    verify(answer, times(0)).arbitrate(answer);
  }

  @Test
  public void shouldInitWith6Rounds() {
    Game game = new Game();
    assertEquals(6,  game.getLeftRound());
  }
}