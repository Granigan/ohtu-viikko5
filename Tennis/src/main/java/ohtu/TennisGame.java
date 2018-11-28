package ohtu;

public class TennisGame {

    private int player1Points = 0;
    private int player2Points = 0;
    private final String player1Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name)) {
            player1Points += 1;
        } else {
            player2Points += 1;
        }
    }

    public String getScoreString() {
        if (player1Points == player2Points) {
            return draw();

        } else if (player1Points >= 4 || player2Points >= 4) {
            return endGame();

        } else {
            return normalGame();
        }
    }

    private String normalGame() {
        String scoreString = "";
        scoreString += pointsToString(player1Points);
        scoreString += "-";
        scoreString += pointsToString(player2Points);
        return scoreString;
    }

    private String draw() {
        String scoreString;
        switch (player1Points) {
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

    private String endGame() {
        String scoreString;
        int minusResult = player1Points - player2Points;
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
}
