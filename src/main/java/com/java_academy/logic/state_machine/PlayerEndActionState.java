package com.java_academy.logic.state_machine;

import com.java_academy.logic.model.MessageObject;
import com.java_academy.logic.model.Players;
import com.java_academy.logic.state_machine.core.GameState;

import java.util.function.Consumer;

/**
 * @author Bartlomiej Janik
 * @since 7/31/2017
 */
public class PlayerEndActionState implements GameState {

    private Players currentPlayer;
    private Boolean hasBeenHit;

    public PlayerEndActionState(Players currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void display(Consumer<MessageObject> displayConsumer) {

    }

    @Override
    public GameState changeState(String message) {
        hasBeenHit = somethingWasHitted();
        currentPlayer.getPlayer().decrementNukeCounter();

        if(checkIfPlayerWon(currentPlayer)) {
            return new BattleResultState(currentPlayer);
        } else if(hasBeenHit){
            return new PlayerActionState(currentPlayer);
        } else {
            return new PlayerActionState(currentPlayer.getOpponent());
        }
    }

    @Override
    public boolean isEndingState() {
        return false;
    }

    private boolean checkIfPlayerWon(Players player) {
        return player.getOpponent().getPlayer().hasNoFleet();
    }

    public Boolean somethingWasHitted() {
        return false;
    }
}
