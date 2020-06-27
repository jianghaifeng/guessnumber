package com.example.guessnumber.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ConsoleOutputTest {

  @Mock
  PrintStream printStream;

  @Test
  public void shouldOutputToConsole() {
    ConsoleOutput consoleOutput = new ConsoleOutput();

    System.setOut(printStream);

    consoleOutput.output("hello");

    verify(printStream).println("hello");

    System.setOut(System.out);
  }

}