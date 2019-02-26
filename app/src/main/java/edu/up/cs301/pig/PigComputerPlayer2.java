package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.NotYourTurnInfo;

public class PigComputerPlayer2 extends GameComputerPlayer {
    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer2(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if(info instanceof NotYourTurnInfo){
            return;
        }
        if(((PigGameState)info).getRunningTotal() >= 10){
            game.sendAction(new PigHoldAction(this));
        }
        else{
            game.sendAction(new PigRollAction(this));
        }
    }//receiveInfo

}
