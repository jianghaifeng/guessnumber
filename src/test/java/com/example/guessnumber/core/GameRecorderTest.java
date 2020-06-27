package com.example.guessnumber.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRecorderTest {

  @Test
  public void shouldHaveARecordWhen1RecordIsAdded() {
    GameRecorder recorder = new GameRecorder();
    GameAnswer answer  = new GameAnswer("1234");
    GameResult result = new GameResult(1,1);

    assertEquals(0, recorder.getRecords().size());

    recorder.addRecord(answer, result);
    assertEquals(1, recorder.getRecords().size());
  }
}