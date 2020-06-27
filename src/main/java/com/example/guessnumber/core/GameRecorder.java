package com.example.guessnumber.core;

import java.util.ArrayList;
import java.util.List;

public class GameRecorder {
  private List<GameAnswer> answerList;
  private List<GameResult> resultList;

  GameRecorder() {
    answerList = new ArrayList<>();
    resultList = new ArrayList<>();
  }

  public void addRecord(GameAnswer answer, GameResult result) {
  }

  public List<String> getRecords() {
    List<String> records = new ArrayList<>();
    return records;
  }
}
