package com.example.guessnumber.core;

public class Game {
  private GameAnswer target;

  public Game() {
    RandomAnswerGenerator generator = new RandomAnswerGenerator();
    this.target = generator.generate();
  }

  public Game(RandomAnswerGenerator generator) {
    this.target = generator.generate();
  }

  public GameAnswer getTarget() {
    return target;
  }

  public String guess(GameAnswer candidate) {
    if (candidate.validate()) {
      return target.arbitrate(candidate);
    }
    return "";
  }
}
