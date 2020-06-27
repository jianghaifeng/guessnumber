package com.example.guessnumber.console;

import com.example.guessnumber.core.GameAnswer;
import com.example.guessnumber.core.GameRecorder;
import com.example.guessnumber.core.RandomAnswerGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsoleGameAppTest {
  @Mock
  RandomAnswerGenerator mockGenerator;

  @Mock
  ConsoleInput mockInput;

  @Mock
  ConsoleOutput mockOutput;

  @Mock
  GameRecorder mockRecorder;

  private ConsoleGameApp gameApp;

  @BeforeEach
  public void setup() {
    when(mockGenerator.generate()).thenReturn(new GameAnswer("1234"));
    gameApp = new ConsoleGameApp(mockGenerator, mockRecorder, mockOutput, mockInput);
  }

  @Test
  public void shouldHave6ChancesToGuess() {

    when(mockInput.inputAnswer()).thenReturn(new GameAnswer("5678"));

    gameApp.play();

    verify(mockInput, times(6)).inputAnswer();
  }

  @Test
  public void shouldFinishGameWhenGuessCorrectNumber() {

    when(mockInput.inputAnswer())
        .thenReturn(new GameAnswer("5678"))
        .thenReturn(new GameAnswer("1256"))
        .thenReturn(new GameAnswer("1234"));

    gameApp.play();

    verify(mockInput, times(3)).inputAnswer();
  }

  @Test
  public void shouldSaveRecordsWhenGuessNumberIsValid() {
    when(mockInput.inputAnswer())
        .thenReturn(new GameAnswer("5678"))
        .thenReturn(new GameAnswer("1256"))
        .thenReturn(new GameAnswer("1234"));

    gameApp.play();

    verify(mockRecorder, times(3)).addRecord(any(), any());
  }

  @Test
  public void shouldNotSaveRecordWhenGuessNumberIsInvalid() {
    GameAnswer invalidAnswer = new GameAnswer("1123");
    when(mockInput.inputAnswer())
        .thenReturn(new GameAnswer("5678"))
        .thenReturn(new GameAnswer("1256"))
        .thenReturn(invalidAnswer)
        .thenReturn(new GameAnswer("1234"));

    gameApp.play();

    verify(mockRecorder, times(0)).addRecord(eq(invalidAnswer), any());
  }

  @Test
  public void shouldOutputSuccessWhenGameFinishedSuccess() {
    GameAnswer invalidAnswer = new GameAnswer("1123");
    when(mockInput.inputAnswer())
        .thenReturn(new GameAnswer("5678"))
        .thenReturn(new GameAnswer("1256"))
        .thenReturn(invalidAnswer)
        .thenReturn(new GameAnswer("1234"));

    gameApp.play();

    verify(mockOutput, times(1)).output("SUCCESS!");
  }
}