package com.java_academy.logic.state_machine;

import com.java_academy.logic.model.MessageObject;
import com.java_academy.logic.model.Players;
import com.java_academy.logic.state_machine.core.GameState;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class NewGameState implements GameState {


    @Override
    public void display(Consumer<MessageObject> displayConsumer) {
        displayConsumer.accept(new MessageObject(Players.FIRST_PLAYER, "NEW!"));
        displayConsumer.accept(new MessageObject(Players.SECOND_PLAYER, "NEW!"));
    }

    @Override
    public GameState changeState(Supplier<String> message) {
        return new FirstRoundState();
    }

    @Override
    public boolean isEndingState() {
        return false;
    }
}