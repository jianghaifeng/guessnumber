package com.example.guessnumber.console;

import com.example.guessnumber.core.Game;
import com.example.guessnumber.core.GameAnswer;
import com.example.guessnumber.core.GameRecorder;
import com.example.guessnumber.core.GameResult;
import com.example.guessnumber.core.GameStatus;
import com.example.guessnumber.core.RandomAnswerGenerator;

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
    output.output("====Welcome to Guess Number game====");
    while (game.getStatus() == GameStatus.RUNING) {
      output.output("---history---");
      recorder.getRecords().stream().forEach(output::output);
      output.output("-------------");
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
      output.output("The answer is: " + game.getTarget().getAnswer());
    }
  }
}
