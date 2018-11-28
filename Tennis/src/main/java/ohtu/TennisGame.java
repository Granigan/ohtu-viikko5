package ohtu;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    private String draw(int ballsWonByEachPlayer) {
        String scoreString;
        switch (ballsWonByEachPlayer) {
            case 0:
                scoreString = "Love-All";
                break;
            case 1:
                scoreString = "Fifteen-All";
                break;
            case 2:
                scoreString = "Thirty-All";
                break;
            case 3:
                scoreString = "Forty-All";
                break;
            default:
                scoreString = "Deuce";
                break;

        }
        return scoreString;
    }

    private String overtime(int score1, int score2) {
        String scoreString;
        int minusResult = score1 - score2;
        if (minusResult == 1) {
            scoreString = "Advantage player1";
        } else if (minusResult == -1) {
            scoreString = "Advantage player2";
        } else if (minusResult >= 2) {
            scoreString = "Win for player1";
        } else {
            scoreString = "Win for player2";
        }

        return scoreString;
    }

    private String pointsToString(int points) {
        String scoreString;
        switch (points) {
            case 0:
                scoreString = "Love";
                break;
            case 1:
                scoreString = "Fifteen";
                break;
            case 2:
                scoreString = "Thirty";
                break;
            default:
                scoreString = "Forty";
                break;
        }

        return scoreString;
    }

    public String getScore() {
        String scoreString = "";
        int tempScore = 0;
        if (m_score1 == m_score2) {
            scoreString = draw(m_score1);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            scoreString = overtime(m_score1, m_score2);
        } else {

            for (int i = 1; i < 3; i++) {
                if (i == 1) {
                    tempScore = m_score1;
                } else {
                    scoreString += "-";
                    tempScore = m_score2;
                }
                switch (tempScore) {
                    case 0:
                        scoreString += "Love";
                        break;
                    case 1:
                        scoreString += "Fifteen";
                        break;
                    case 2:
                        scoreString += "Thirty";
                        break;
                    case 3:
                        scoreString += "Forty";
                        break;
                }
            }
        }
        return scoreString;
    }
}
