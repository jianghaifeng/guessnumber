import com.example.guessnumber.console.ConsoleGameApp;
import com.example.guessnumber.console.ConsoleInput;
import com.example.guessnumber.console.ConsoleOutput;
import com.example.guessnumber.core.GameRecorder;
import com.example.guessnumber.core.RandomAnswerGenerator;

public class Main {
  public static void main(String[] args) {
    ConsoleGameApp game = new ConsoleGameApp(
        new RandomAnswerGenerator(),
        new GameRecorder(),
        new ConsoleOutput(),
        new ConsoleInput()
    );

    game.play();
  }
}
