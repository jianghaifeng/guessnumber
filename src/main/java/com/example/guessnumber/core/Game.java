package com.example.guessnumber.core;

public class Game {
  private final int ROUND = 6;
  private GameAnswer target;
  private int leftRound;

  public Game() {
    RandomAnswerGenerator generator = new RandomAnswerGenerator();
    this.target = generator.generate();
    leftRound = ROUND;
  }

  public Game(RandomAnswerGenerator generator) {
    this.target = generator.generate();
    leftRound = ROUND;
  }

  public int getLeftRound() {
    return leftRound;
  }

  public GameAnswer getTarget() {
    return target;
  }

  public String guess(GameAnswer candidate) {
    if (candidate.validate()) {
      leftRound--;
      return target.arbitrate(candidate);
    }
    return "";
  }
}
