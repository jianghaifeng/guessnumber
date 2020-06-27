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

  public void updateStatus(GameResult result) {
    if (result.isSuccess()) {
      status = GameStatus.SUCCESS;
    } else if (getRoundsLeft() == 0) {
      status = GameStatus.FAIL;
    }
  }

  public GameResult guess(GameAnswer candidate) {
    GameResult result = new GameResult(0, 0);
    if (candidate.validate()) {
      decreaseLeftRound();
      result = target.arbitrate(candidate);
      updateStatus(result);
    }
    return result;
  }
}
