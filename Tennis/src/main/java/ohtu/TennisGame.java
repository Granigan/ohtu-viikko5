package ohtu;

public class TennisGame {

    private int player1Points = 0;
    private int player2Points = 0;
    private final String player1Name;
    private final String player2Name;
    private final int deuceLevel = 4;
    private final int mustWinBy = 2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name)) {
            player1Points += 1;
        } else {
            player2Points += 1;
        }
    }

    public String getScore() {
        if (player1Points == player2Points) {
            return draw();

        } else if (player1Points >= deuceLevel || player2Points >= deuceLevel) {
            return endGame();

        } else {
            return normalGame();
        }
    }

    private String normalGame() {
        return pointsToString(player1Points) + "-" + pointsToString(player2Points);
    }

    private String draw() {
        if (player1Points >= deuceLevel) {
            return "Deuce";
        }
        return pointsToString(player1Points) + "-All";
    }

    private String endGame() {
        int differenceInPoints = player1Points - player2Points;
        if (Math.abs(differenceInPoints) < mustWinBy) {
            return advantage(differenceInPoints);
        } else {
            return victory(differenceInPoints);
        }
    }

    private String advantage(int pointDifference) {
        if (pointDifference > 0) {
            return "Advantage " + player1Name;
        }
        return "Advantage " + player2Name;
    }

    private String victory(int pointDifference) {
        if (pointDifference > 0) {
            return "Win for " + player1Name;
        }
        return "Win for " + player2Name;
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
