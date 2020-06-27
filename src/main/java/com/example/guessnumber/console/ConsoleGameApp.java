package com.example.guessnumber.console;

import com.example.guessnumber.core.Game;
import com.example.guessnumber.core.GameRecorder;
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

  }
}
