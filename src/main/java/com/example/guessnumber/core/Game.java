package com.example.guessnumber.core;

public class Game {
  private GameAnswer target;

  public Game() {
    RandomNumberGenerator generator = new RandomNumberGenerator();
    this.target = new GameAnswer(generator.generate());
  }

  public Game(RandomNumberGenerator generator) {
    this.target = new GameAnswer(generator.generate());
  }

  public GameAnswer getTarget() {
    return target;
  }

  public String guess(GameAnswer candidate) {
    return target.arbitrate(candidate);
  }
}
