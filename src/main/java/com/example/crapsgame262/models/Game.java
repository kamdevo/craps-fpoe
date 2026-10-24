package com.example.crapsgame262.models;

public class Game {

    private int roll;
    private int point;
    private int gamesWon;
    private int gamesLost;

    public void play(int dice1Value, int dice2Value) {
        roll = dice1Value + dice2Value;

        if (hasPoint()) {
            playPointRoll();
        } else {
            playComeOutRoll();
        }
    }

    // Tiro de salida: 7 u 11 gana, 2, 3 o 12 es Craps y pierde, cualquier otro número establece el punto
    private void playComeOutRoll() {
        if (roll == 7 || roll == 11) {
            winGame();
        } else if (roll == 2 || roll == 3 || roll == 12) {
            loseGame();
        } else {
            point = roll;
        }
    }

    // Con punto: sacar el punto gana, sacar 7 pierde, cualquier otro número sigue lanzando
    private void playPointRoll() {
        if (roll == point) {
            winGame();
        } else if (roll == 7) {
            loseGame();
        }
    }

    private boolean hasPoint() {
        return point != 0;
    }

    private void winGame() {
        gamesWon++;
        point = 0;
    }

    private void loseGame() {
        gamesLost++;
        point = 0;
    }

    public int getRoll() {
        return roll;
    }

    public int getPoint() {
        return point;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }
}
