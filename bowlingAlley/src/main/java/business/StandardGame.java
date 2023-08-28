package business;

import enums.ScoreType;

public class StandardGame implements BowlingAlleyGame {
    private final Integer totalNumberOfRounds;
    private final Integer numberOfChancesInEachRound;
    private final Integer numberOfBonusPointsForStrike;
    private final Integer numberOfBonusPointsForSpare;
    private final Integer numberOfBonusBallsOnStrikeOrSpareInLastRound;

    public StandardGame(Integer totalNumberOfRounds, Integer numberOfChancesInEachRound, Integer numberOfBonusPointsForStrike, Integer numberOfBonusPointsForSpare, Integer numberOfBonusBallsOnStrikeOrSpareInLastRound) {
        this.totalNumberOfRounds = totalNumberOfRounds;
        this.numberOfChancesInEachRound = numberOfChancesInEachRound;
        this.numberOfBonusPointsForStrike = numberOfBonusPointsForStrike;
        this.numberOfBonusPointsForSpare = numberOfBonusPointsForSpare;
        this.numberOfBonusBallsOnStrikeOrSpareInLastRound = numberOfBonusBallsOnStrikeOrSpareInLastRound;
    }

    @Override
    public Integer getTotalNumberOfRounds() {
        return totalNumberOfRounds;
    }

    @Override
    public Integer getNumberOfChancesInEachRound() {
        return numberOfChancesInEachRound;
    }

    @Override
    public Integer getNumberOfBonusPointsForStrike() {
        return numberOfBonusPointsForStrike;
    }

    @Override
    public Integer getNumberOfBonusPointsForSpare() {
        return numberOfBonusPointsForSpare;
    }

    @Override
    public Integer getNumberOfBonusBallsOnStrikeOrSpareInLastRound() {
        return numberOfBonusBallsOnStrikeOrSpareInLastRound;
    }

    @Override
    public Boolean isEligibleForBonusBalls(Integer roundNumber, ScoreType scoreType) {
        return roundNumber.equals(totalNumberOfRounds) && scoreType != null && (scoreType.equals(ScoreType.STRIKE) || scoreType.equals(ScoreType.SPARE));
    }

}
