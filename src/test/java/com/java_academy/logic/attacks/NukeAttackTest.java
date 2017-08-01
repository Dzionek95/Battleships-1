package com.java_academy.logic.attacks;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.java_academy.logic.fleet_settings.FleetBuilder;
import com.java_academy.logic.jsonModel.MarkedIndexes;
import com.java_academy.logic.model.BoardManager;
import com.java_academy.logic.model.Ships;


public class NukeAttackTest {
	
	private BoardManager board;
	
	@BeforeTest
	public void createBoard() {
		Ships ships = FleetBuilder.getNonLocalizedShips();
		board = new BoardManager(ships, 10);
	}
	
	@Test
	public void testAttackGetNineFields() {
		Attack attack = new NukeAttack(board);
		MarkedIndexes markedIndexes = attack.attack(23);
		
		assertEquals(markedIndexes.getMap().size(), 9);
	}
	
	@Test
	public void testAttackGetSixFields() {
		Attack attack = new NukeAttack(board);
		MarkedIndexes markedIndexes = attack.attack(30);
		
		assertEquals(markedIndexes.getMap().size(), 6);
	}
}
