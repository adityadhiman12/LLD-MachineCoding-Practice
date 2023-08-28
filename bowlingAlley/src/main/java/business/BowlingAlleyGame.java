package business;

import enums.ScoreType;

public interface BowlingAlleyGame {
    Integer getTotalNumberOfRounds();
    Integer getNumberOfChancesInEachRound();
    Integer getNumberOfBonusPointsForStrike();
    Integer getNumberOfBonusPointsForSpare();
    Integer getNumberOfBonusBallsOnStrikeOrSpareInLastRound();
    Boolean isEligibleForBonusBalls(Integer roundNumber, ScoreType scoreType);
}
