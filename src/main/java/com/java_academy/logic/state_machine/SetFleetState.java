package com.java_academy.logic.state_machine;

import com.java_academy.logic.json_model.MarkedIndexes;
import com.java_academy.logic.json_model.MessageCreator;
import com.java_academy.logic.model.Cell;
import com.java_academy.logic.model.MessageObject;
import com.java_academy.logic.model.Player;
import com.java_academy.logic.model.Players;
import com.java_academy.logic.state_machine.core.GameState;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

/**
 * @author Bartlomiej Janik
 * @since 7/31/2017
 */
public class SetFleetState implements GameState {

    @Override
    public void display(Consumer<MessageObject> displayConsumer) {
    	displayConsumer.accept(new MessageObject(Players.FIRST_PLAYER, MessageCreator.createJsonMessageByKey("set.fleet")));
        displayConsumer.accept(new MessageObject(Players.SECOND_PLAYER, MessageCreator.createJsonMessageByKey("set.fleet")));
    }

    @Override
    public GameState changeState(String message) {
        //TODO handling user input about fleet settings
        createBoardWithFleet(Players.FIRST_PLAYER.getPlayer());
        createBoardWithFleet(Players.SECOND_PLAYER.getPlayer());

        MarkedIndexes firstPlayerBoard = convertShipIndexesToMarkedIndexes(Players.FIRST_PLAYER.getPlayer());
        MarkedIndexes secondPlayerBoard = convertShipIndexesToMarkedIndexes(Players.SECOND_PLAYER.getPlayer());

        firstPlayerBoard.setIsMyBoard(true);
        secondPlayerBoard.setIsMyBoard(true);
        
        return new GetBoardForPlayer(firstPlayerBoard, secondPlayerBoard);
    }

    //TODO REFACTOR THIS
    private MarkedIndexes convertShipIndexesToMarkedIndexes(Player player) {
		Map<Integer, Boolean> miMap = new HashMap<>();
		for(Entry<Integer, Cell> entry: player.getBoard().getBoardMap().entrySet()) {
			if(entry.getValue().equals(Cell.SHIP_ALIVE)) {
				miMap.put(entry.getKey(), true);
			}
		}
		return new MarkedIndexes("data", miMap);
	}

	private void createBoardWithFleet(Player player) {
        //TODO SHIPYARD USER
        player.createFleet();
    }
    
    
}
