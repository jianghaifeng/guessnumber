package com.example.guessnumber.console;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputTest {
  @Test
  public void shouldGetGameAnswerFromStandardInput() {
    String data = "1234";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());

    ConsoleInput input = new ConsoleInput();
    System.setIn(inputStream);
    assertEquals(data, input.inputAnswer().getAnswer());

    System.setIn(System.in);
  }
}