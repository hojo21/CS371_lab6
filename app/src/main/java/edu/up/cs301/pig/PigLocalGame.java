package edu.up.cs301.pig;

import edu.up.cs301.game.Game;
import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private PigGameState gameState;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        gameState = new PigGameState();
    }


    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if(playerIdx == gameState.getTurnID()){
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (action instanceof PigHoldAction) {
            if (gameState.getTurnID() == 0) {
                gameState.setPlayer0Score(gameState.getPlayer0Score() + gameState.getRunningTotal());
            } else {
                gameState.setPlayer1Score(gameState.getPlayer1Score() + gameState.getRunningTotal());
            }

            gameState.setRunningTotal(0);

            if (players.length > 1) {
                if (gameState.getTurnID() == 0) {
                    gameState.setTurnID(1);
                } else {
                    gameState.setTurnID(0);
                }
            }

            return true;
        }

        if (action instanceof PigRollAction) {
            gameState.setDieValue((int)(Math.random() * 6 + 1));

            if (gameState.getDieValue() == 1) {
                gameState.setRunningTotal(0);

                if (players.length > 1) {
                    if (gameState.getTurnID() == 0) {
                        gameState.setTurnID(1);
                    } else {
                        gameState.setTurnID(0);
                    }
                }
                return true;
            }

            gameState.setRunningTotal(gameState.getDieValue() + gameState.getRunningTotal());
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState copyGS = new PigGameState(gameState);
        p.sendInfo(copyGS);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if (gameState.getPlayer0Score() >= 50) {
            return playerNames[0] + " has won!";
        }

        if (gameState.getPlayer1Score() >= 50) {
            return playerNames[1] + "has won!";
        }

        return null;
    }

}// class PigLocalGame
