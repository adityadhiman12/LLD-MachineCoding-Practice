package dao;

import business.BowlingAlleyGame;
import business.StandardGame;
import enums.ScoreType;
import model.Player;
import model.RoundStats;
import model.Score;

import java.util.*;

public class BowlingAlleyDaoImpl implements BowlingAlleyDao{
    private List<Player> players;
    private Map<String, List<RoundStats>> playerIdToRoundStatsMap;

    private BowlingAlleyGame gameRule;

    public BowlingAlleyDaoImpl(BowlingAlleyGame gameRule) {
        this.players = new ArrayList<>();
        this.playerIdToRoundStatsMap = new HashMap<>();
        this.gameRule = gameRule;
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public int getTotalPlayers() {
        return players.size();
    }

    @Override
    public void printScoreCard() {
        TreeMap<Integer, List<Player>> finalPointsToPlayerMap = new TreeMap<>(Collections.reverseOrder());
        for(String playerId : playerIdToRoundStatsMap.keySet()) {
            Integer totalPoints = playerIdToRoundStatsMap.get(playerId).stream().mapToInt(RoundStats::getTotalPoints).sum();
            List<Player> totalPlayers = finalPointsToPlayerMap.getOrDefault(totalPoints, new ArrayList<>());
            Optional<Player> player = players.stream().filter(player1 -> player1.getPlayerId().equals(playerId)).findFirst();
            if(player.isPresent()) {
                totalPlayers.add(player.get());
            }
            finalPointsToPlayerMap.put(totalPoints, players);
        }
        System.out.println(finalPointsToPlayerMap);
    }

    public void updateScoreCard() {

    }

    @Override
    public void startGame() {
        for (int round = 1; round <= gameRule.getTotalNumberOfRounds(); round++) {
            for (Player player : players) {
                RoundStats roundStats = new RoundStats(round);
                Integer totalScore = 0;
                Boolean gotStrike = false;
                Boolean isEligibleForBonus = false;
                for (int chance = 1; chance <= gameRule.getNumberOfChancesInEachRound(); chance++) {
                    System.out.print("Player: " + player.getName() + " Round: " + round + " - Enter your number of hits: ");
                    Scanner scanner = new Scanner(System.in);
                    Integer score = scanner.nextInt();
                    totalScore += score;
                    Score chanceScore = new Score(score);
                    if (isStrike(chance, score)) {
                        gotStrike = true;
                        chanceScore.setScoreType(ScoreType.STRIKE);
                        roundStats.addTotalPoints(gameRule.getNumberOfBonusPointsForStrike());
                    } else if (!gotStrike && isSpare(totalScore)) {
                        chanceScore.setScoreType(ScoreType.SPARE);
                        roundStats.addTotalPoints(gameRule.getNumberOfBonusPointsForStrike());
                    }
                    roundStats.addTotalPoints(score);
                    roundStats.addScore(chanceScore);
                    if (isEligibleForBonusBalls(round, chanceScore.getScoreType())) {
                        isEligibleForBonus = true;
                    }
                }

                if (isEligibleForBonus) {
                    totalScore = 0;
                    gotStrike = false;
                    for (int extraBalls = 1; extraBalls <= gameRule.getNumberOfBonusBallsOnStrikeOrSpareInLastRound(); extraBalls++) {
                        System.out.print("Round: " + round + " - Enter your number of hits: ");
                        Scanner scanner = new Scanner(System.in);
                        Integer score = scanner.nextInt();
                        totalScore += score;
                        Score chanceScore = new Score(score);
                        if (isStrike(extraBalls, score)) {
                            gotStrike = true;
                            chanceScore.setScoreType(ScoreType.STRIKE);
                            roundStats.addTotalPoints(gameRule.getNumberOfBonusPointsForStrike());
                        } else if (!gotStrike && isSpare(totalScore)) {
                            chanceScore.setScoreType(ScoreType.SPARE);
                            roundStats.addTotalPoints(gameRule.getNumberOfBonusPointsForStrike());
                        }
                        roundStats.addTotalPoints(score);
                        roundStats.addScore(chanceScore);
                    }
                }
                List<RoundStats> roundStatsList = playerIdToRoundStatsMap.getOrDefault(player.getPlayerId(), new ArrayList<>());
                roundStatsList.add(roundStats);
                playerIdToRoundStatsMap.put(player.getPlayerId(), roundStatsList);
                System.out.println("RoundStats:  " + roundStats.getTotalPoints() + " for player: " + player.getName());
            }
        }
    }

    private boolean isStrike(int chance, int currentScore) {
        return chance == 1 && currentScore == 10;
    }

    private boolean isSpare(int totalScore) {
        return totalScore == 10;
    }

    private boolean isEligibleForBonusBalls(Integer round, ScoreType scoreType) {
        return gameRule.isEligibleForBonusBalls(round, scoreType);
    }
}
