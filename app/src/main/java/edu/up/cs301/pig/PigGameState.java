package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {

    private int turnID;

    private int player0Score;
    private int player1Score;

    private int runningTotal;
    private int dieValue;

    public PigGameState() {
        turnID = 0;
        player0Score = 0;
        player1Score = 0;
        runningTotal = 0;
        dieValue = 1;
    }

    public PigGameState(PigGameState toCopy) {
        turnID = toCopy.turnID;
        player0Score = toCopy.player0Score;
        player1Score = toCopy.player1Score;
        runningTotal = toCopy.runningTotal;
        dieValue = toCopy.dieValue;
    }

    public int getTurnID() {
        return turnID;
    }

    public int getPlayer0Score() {
        return player0Score;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public int getDieValue() {
        return dieValue;
    }

    public void setTurnID(int turnID) {
        this.turnID = turnID;
    }

    public void setPlayer0Score(int player0Score) {
        this.player0Score = player0Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public void setRunningTotal(int runningTotal) {
        this.runningTotal = runningTotal;
    }

    public void setDieValue(int dieValue) {
        this.dieValue = dieValue;
    }
}
