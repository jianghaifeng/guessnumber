package com.example.guessnumber.core;

public class Game {
  private GameAnswer target;
  private GameAnswerArbitrator arbitrator;

  public Game() {
    RandomNumberGenerator generator = new RandomNumberGenerator();
    this.arbitrator =  new GameAnswerArbitrator();
    this.target = new GameAnswer(generator.generate());
  }

  public Game(RandomNumberGenerator generator) {
    arbitrator = new GameAnswerArbitrator();
    this.target = new GameAnswer(generator.generate());
  }

  public Game(RandomNumberGenerator generator, GameAnswerArbitrator arbitrator) {
    this.arbitrator = arbitrator;
    this.target = new GameAnswer(generator.generate());
  }

  public GameAnswer getTarget() {
    return target;
  }

  public String guess(GameAnswer candidate) {
    return arbitrator.check(target, candidate);
  }
}
