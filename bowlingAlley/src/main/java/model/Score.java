package model;

import enums.ScoreType;

public class Score {
    private int noOfPinsDown;
    private ScoreType scoreType;
    public Score(Integer noOfPinsDown) {
        this.noOfPinsDown = noOfPinsDown;
    }

    public int getNoOfPinsDown() {
        return noOfPinsDown;
    }

w
    public void setNoOfPinsDown(int noOfPinsDown) {
        this.noOfPinsDown = noOfPinsDown;
    }

    public ScoreType getScoreType() {
        return scoreType;
    }

    public void setScoreType(ScoreType scoreType) {
        this.scoreType = scoreType;
    }
}
