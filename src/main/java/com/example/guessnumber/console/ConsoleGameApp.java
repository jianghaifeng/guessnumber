package com.example.guessnumber.console;

import com.example.guessnumber.core.Game;
import com.example.guessnumber.core.GameAnswer;
import com.example.guessnumber.core.GameRecorder;
import com.example.guessnumber.core.GameResult;
import com.example.guessnumber.core.GameStatus;
import com.example.guessnumber.core.RandomAnswerGenerator;

import java.util.List;

public class ConsoleGameApp {
  Game game;
  GameRecorder recorder;
  ConsoleOutput output;
  ConsoleInput input;

  public ConsoleGameApp(RandomAnswerGenerator generator, GameRecorder recorder, ConsoleOutput output, ConsoleInput input) {
    this.game = new Game(generator);
    this.recorder = recorder;
    this.output = output;
    this.input = input;
  }

  public void play() {
    while (game.getStatus() == GameStatus.RUNING) {
      List<String> reocords = recorder.getRecords();
      for (int i = 0; i < reocords.size(); i++) {
        output.output(reocords.get(i));
      }
      output.output("Guess a number: ");
      GameAnswer answer = input.inputAnswer();
      GameResult result = game.guess(answer);
      if (answer.validate()) {
        recorder.addRecord(answer, result);
      }
    }
    if (game.getStatus() == GameStatus.SUCCESS) {
      output.output("SUCCESS!");
    } else {
      output.output("FAIL!");
    }
  }
}
