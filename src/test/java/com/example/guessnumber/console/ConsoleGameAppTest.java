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
import static org.mockito.ArgumentMatchers.contains;
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

  private GameAnswer wrongAnswer;
  private GameAnswer correctAnswer;
  private GameAnswer invalidAnswer;

  @BeforeEach
  public void setup() {
    when(mockGenerator.generate()).thenReturn(new GameAnswer("1234"));
    gameApp = new ConsoleGameApp(mockGenerator, mockRecorder, mockOutput, mockInput);

    invalidAnswer = new GameAnswer("112");
    wrongAnswer = new GameAnswer("5678");
    correctAnswer = new GameAnswer("1234");
  }

  @Test
  public void shouldHave6ChancesToGuess() {

    when(mockInput.inputAnswer()).thenReturn(wrongAnswer);

    gameApp.play();

    verify(mockInput, times(6)).inputAnswer();
  }

  @Test
  public void shouldFinishGameWhenGuessCorrectNumber() {

    when(mockInput.inputAnswer())
        .thenReturn(wrongAnswer)
        .thenReturn(wrongAnswer)
        .thenReturn(correctAnswer);

    gameApp.play();

    verify(mockInput, times(3)).inputAnswer();
  }

  @Test
  public void shouldSaveRecordsWhenGuessNumberIsValid() {
    when(mockInput.inputAnswer())
        .thenReturn(wrongAnswer)
        .thenReturn(wrongAnswer)
        .thenReturn(correctAnswer);

    gameApp.play();

    verify(mockRecorder, times(3)).addRecord(any(), any());
  }

  @Test
  public void shouldNotSaveRecordWhenGuessNumberIsInvalid() {
    when(mockInput.inputAnswer())
        .thenReturn(wrongAnswer)
        .thenReturn(wrongAnswer)
        .thenReturn(invalidAnswer)
        .thenReturn(correctAnswer);

    gameApp.play();

    verify(mockRecorder, times(0)).addRecord(eq(invalidAnswer), any());
  }

  @Test
  public void shouldOutputSuccessWhenGameFinishedSuccess() {
    when(mockInput.inputAnswer())
        .thenReturn(wrongAnswer)
        .thenReturn(wrongAnswer)
        .thenReturn(invalidAnswer)
        .thenReturn(correctAnswer);

    gameApp.play();

    verify(mockOutput, times(1)).output("SUCCESS!");
  }

  @Test
  public void shouldOutputFailWhenGameFinishedFailed() {
    when(mockInput.inputAnswer())
        .thenReturn(wrongAnswer);

    gameApp.play();

    verify(mockOutput, times(1)).output("FAIL!");
  }

  @Test
  public void shouldPromptInput() {
    when(mockInput.inputAnswer())
        .thenReturn(wrongAnswer);

    gameApp.play();

    verify(mockOutput, times(6)).output("Guess a number: ");
  }

  @Test
  public void shouldShowHistoryBeforeEachInput() {
    ConsoleGameApp gameAppWithRecorder = new ConsoleGameApp(mockGenerator, new GameRecorder(), mockOutput, mockInput);
    when(mockInput.inputAnswer())
        .thenReturn(wrongAnswer)
        .thenReturn(wrongAnswer)
        .thenReturn(correctAnswer);

    gameAppWithRecorder.play();

    verify(mockOutput, times(3)).output(contains(wrongAnswer.getAnswer()));
  }

  @Test
  public void shouldPromptForWrongInput() {
    when(mockInput.inputAnswer())
        .thenReturn(invalidAnswer)
        .thenReturn(invalidAnswer)
        .thenReturn(invalidAnswer)
        .thenReturn(invalidAnswer)
        .thenReturn(invalidAnswer)
        .thenReturn(invalidAnswer)
        .thenReturn(invalidAnswer)
        .thenReturn(invalidAnswer)
        .thenReturn(wrongAnswer);

    gameApp.play();

    verify(mockOutput, times(8)).output("Wrong Input，Input again");
  }
}