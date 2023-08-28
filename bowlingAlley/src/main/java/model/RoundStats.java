package model;

import java.util.ArrayList;
import java.util.List;

public class RoundStats {
    private int roundNo;
    private List<Score> scores;
    private int totalPoints;

    public RoundStats(Integer roundNo) {
        this.roundNo = roundNo;
        this.scores = new ArrayList<>();
        this.totalPoints = 0;
    }

    public void addScore(Score score) {
        scores.add(score);
    }
    public int getRoundNo() {
        return roundNo;
    }
    public void addTotalPoints(Integer points) {
        this.totalPoints += points;
    }
    public void setRoundNo(int roundNo) {
        this.roundNo = roundNo;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
