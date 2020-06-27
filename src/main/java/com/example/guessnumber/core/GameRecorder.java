package com.example.guessnumber.core;

import java.util.ArrayList;
import java.util.List;

public class GameRecorder {
  private List<String> recordList;

  public GameRecorder() {
    recordList = new ArrayList<>();
  }

  public void addRecord(GameAnswer answer, GameResult result) {
    String recordStr = String.format("%s: %s",
        answer.getAnswer(),
        result.getResult());
    recordList.add(recordStr);
  }

  public List<String> getRecords() {
    return recordList;
  }
}
