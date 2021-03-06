# Battleships 2

The purpose of this project is to practise DDD (Delete Driven Development). You can read more about rules in this [article](https://en.wikipedia.org/wiki/Battleship_(game))

### Prerequisites


```
Java 1.8
Maven 3.0.1
```


## Running  

```
To execute GUI part: 
mvn clean install
mvn exec:java -Dexec.mainClass="com.java_academy.Main"
```

```
To execute GameState part: 
mvn clean install
mvn exec:java -Dexec.mainClass="com.java_academy.App"
```

## Testing

```
To test: mvn test
```


## TODO List

- [ ] One game only.
- [ ] 10x10 board
- [ ] Fleet consists of: 4-mast ship, 2 3-mast ships, 3 2-mast ships and 4 1-mast ships.
- [ ] Winner has ships remaining while loser has none.
- [ ] Game messages have configurable target: console (System.out, System.err) or logs or external printer.
- [ ] We are bi-lingual: Polish and English are fine. In future we want to add more languages: messages are to be read from a file for chosen language. Choosing the language depends on configuration variable.

### About the game itself

- [ ] Drawing the boards for a player (fleet board has player's fleet and where opponent shot, "seen" board has where player fired and what he has shot). 
- [ ] Placing the fleet - diagonal placing is disallowed, only horizontal and vertical. Humans can place ships but they can also choose to randomize placement. Ships cannot touch (no adjacent field to a ship can have a ship). Ships can be partially vertical and partially horizontal, if they have the length.
- [ ] Firing the shot - choose a place, shoot. If you hit, you repeat the shot. You can repeat as many times as you hit.
- [ ] Hitting the ship - hit happens when place chosen has enemy ship. Mark this part of ship as hit, ask for another shot. One can repeat the shot into already hit (or even sunken) ship, but this doesn't give the right to another shot.
- [ ] Missing the ship - misses are marked on "seen" board. One can shoot twice in the same place if it's a miss.
- [ ] Sinking the ship - if all masts of a ship are hit, ship sinks. Once the ship has sunk, mark all adjacent fields as "missed", since none of them can have a ship anyway.
- [ ] Sinking last ship, that is, winning.

- [ ] Nuke - thrice per game player chooses a 3x3 area and "nukes" it, that is, all ships within take damage as if shot. This is done in addition to normal shot. Only 4-mast ship has nukes, so once they are sunk, nukes cannot be used.

### Code quality and team setup

- [ ] Holy master - everything on master is holy, this is what is being checked by customer
- [ ] CI server - before anything gets pulled into master, it is integrated with master by CI server, it runs tests, checks, etc. 
- [ ] Reviewers - pull-requests to master that are handled by CI server are then reviewed internally by teammates
- [ ] Outside reviewers - once team says yes, outsiders come in (each team chooses external reviewers). Two external reviewers need to say "code is OK" before it can be pulled to master.
- [x] All code is on GitHub
- [ ] Jenkins (or equivalent) is used as CI server
- [ ] Maven is used by Jenkins and team
- [ ] Maven has Findbugs, JaCoCo and Checkstyle integration 
- [ ] Dependency convergence must be 100%, verified with maven-enforcer plugin
- [ ] All dependencies that are NOT newest are recorded (along with reason why) in the dependencies
- [ ] Dependencies are newest or reason for why is in the docs, versions are kept up to date with Maven versions plugin.
- [ ] Sonar is used to keep quality gates (just internally is fine).
- [ ] Acceptance tests are welcome, one per feature is required
- [ ] Documentation should be provided, explaining program architecture (diagram is necessary, CRC diagrams are most welcome)


