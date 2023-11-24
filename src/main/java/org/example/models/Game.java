package org.example.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Game {

    private final Integer diceCount ;
    private final Integer playerCount ;
    private final Integer boardSize ;
    private final Integer winPosition ;
    Integer counter ;
    Queue<Player> players = new LinkedList<>();
    private HashMap<Integer, Integer> boardJumpPositions ;

    Board board ;

    public Game(Integer diceCount, Integer playerCount, Integer boardSize) {
        this.diceCount = diceCount ;
        this.playerCount = playerCount;
        this.boardSize = boardSize ;
        this.winPosition = (boardSize * boardSize) - 1 ;
        this.initializeGame();
    }

    public void initializeGame() {
        for (int i = 0 ; i < playerCount ; i++) {
            Player player = new Player("player_" + (i+1), i , 0);
            players.add(player) ;
        }
        this.board = new Board(this.boardSize) ;
        this.boardJumpPositions = this.board.getBoardPositionJumpMap();
    }

    public String startGame() {

        Dice dice = new Dice(this.diceCount) ;
        while (!players.isEmpty()) {
            Player curPlayer = players.remove() ;
            Integer diceRoll = dice.rollDice();
            Integer newPos = getPlayerPosition(curPlayer, diceRoll) ;
            System.out.println("Player :" + curPlayer.getName() );
            System.out.println("Dice Roll : " + diceRoll);
            System.out.println("Old position :" + curPlayer.getCurPos());
            System.out.println("Current Position : " + newPos);
            if (newPos.equals(this.winPosition)) {
                return curPlayer.getName() ;
            }
            Player newPlayer = new Player(curPlayer.getName(), curPlayer.getId(), newPos);
            players.add(newPlayer) ;
            System.out.println("---------------------------------------------");

        }
        return null ;
    }

    private Integer getPlayerPosition(Player player, Integer diceRoll) {
        Integer curPos = player.getCurPos();
        Integer newPos = diceRoll + curPos ;
        if (newPos > this.winPosition) {
            return curPos ;
        }
        if (boardJumpPositions.containsKey(newPos)) {
            jumpPositionEncountered(newPos, boardJumpPositions.get(newPos));
            return boardJumpPositions.get(newPos) ;
        }
        return newPos ;
    }

    private void jumpPositionEncountered(Integer k , Integer v) {
        if (v > k) {
            System.out.println("Yeah || You move up the ladder to "  + v);
        } else {
            System.out.println("Oops || You got a snake. Moving you down to " + v);
        }
    }

}
