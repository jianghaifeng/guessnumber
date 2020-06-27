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
    answerList.add(answer);
    resultList.add(result);
  }

  public List<String> getRecords() {
    List<String> records = new ArrayList<>();
    for (int i = 0; i < answerList.size(); i++) {
      String recordStr = String.format("%s:%s",
          answerList.get(i).getAnswer(),
          resultList.get(i).getResult());
      records.add(recordStr);
    }
    return records;
  }
}
