package com.example.guessnumber.console;

import com.example.guessnumber.core.GameAnswer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {
  public GameAnswer inputAnswer() {
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(reader);

    String input = null;
    try {
      input = bufferedReader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new GameAnswer(input);
  }
}
