package com.example.guessnumber.console;

import com.example.guessnumber.core.GameAnswer;
import com.example.guessnumber.core.GameRecorder;
import com.example.guessnumber.core.RandomAnswerGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsoleGameAppTest {
  @Mock
  RandomAnswerGenerator mockGenerator;

  @Mock
  ConsoleInput mockInput;

  @Test
  public void shouldHave6ChancesToGuess() {
    when(mockGenerator.generate()).thenReturn(new GameAnswer("1234"));
    ConsoleGameApp gameApp = new ConsoleGameApp(mockGenerator, new GameRecorder(), new ConsoleOutput(), mockInput);

    when(mockInput.inputAnswer()).thenReturn(new GameAnswer("5678"));

    gameApp.play();

    verify(mockInput, times(6)).inputAnswer();
  }
}