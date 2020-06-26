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
  }

  public Game(RandomAnswerGenerator generator) {
    this.target = generator.generate();
    roundsLeft = ROUND;
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

  public String guess(GameAnswer candidate) {
    if (candidate.validate()) {
      decreaseLeftRound();
      return target.arbitrate(candidate);
    }
    return "";
  }
}
