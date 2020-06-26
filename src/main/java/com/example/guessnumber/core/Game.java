package com.example.guessnumber.core;

public class Game {
  private final int ROUND = 6;
  private GameAnswer target;
  private int roundsLeft;
  private GameStatus status;

  public Game() {
    RandomAnswerGenerator generator = new RandomAnswerGenerator();
    this.target = generator.generate();
    roundsLeft = ROUND;
    status = GameStatus.RUNING;
  }

  public Game(RandomAnswerGenerator generator) {
    this.target = generator.generate();
    roundsLeft = ROUND;
    status = GameStatus.RUNING;
  }

  public int getRoundsLeft() {
    return roundsLeft;
  }

  public void decreaseLeftRound() {
    roundsLeft--;
  }

  public GameAnswer getTarget() {
    return target;
  }

  public GameStatus getStatus() {
    return status;
  }

  public GameResult guess(GameAnswer candidate) {
    GameResult result = new GameResult("");
    if (candidate.validate()) {
      decreaseLeftRound();

      result = target.arbitrate(candidate);

      if (result.isSuccess()) {
        status = GameStatus.SUCCESS;
      }

      if (getRoundsLeft() == 0) {
        status = GameStatus.FAIL;
      }
    }
    return result;
  }
}
