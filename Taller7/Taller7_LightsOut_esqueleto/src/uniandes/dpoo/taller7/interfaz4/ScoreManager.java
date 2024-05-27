package uniandes.dpoo.taller7.interfaz4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScoreManager {
    private List<Score> scores;

    public ScoreManager() {
        scores = new ArrayList<>();
    }

    public void addScore(String playerName, int moves) {
        scores.add(new Score(playerName, moves));
        Collections.sort(scores, Comparator.comparingInt(Score::getMoves));
        if (scores.size() > 10) {
            scores.remove(scores.size() - 1); // Mantener solo los top 10 puntajes
        }
    }

    public List<Score> getTopScores() {
        return scores;
    }

    public static class Score {
        private String playerName;
        private int moves;

        public Score(String playerName, int moves) {
            this.playerName = playerName;
            this.moves = moves;
        }

        public String getPlayerName() {
            return playerName;
        }

        public int getMoves() {
            return moves;
        }

        @Override
        public String toString() {
            return playerName + ": " + moves + " jugadas";
        }
    }
}
