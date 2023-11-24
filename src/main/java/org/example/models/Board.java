package org.example.models;

import java.util.HashMap;

public class Board {

    private final Integer boardSize ;
    private final HashMap<Integer, Integer> positionJumpMap = new HashMap<>() ;

    public Board(Integer boardSize) {
        this.boardSize = boardSize ;
        this.setLaddersAndSnakes();
    }

    private void setLaddersAndSnakes() {
        //ladders
        positionJumpMap.put(4,9) ;
        positionJumpMap.put(14,24);
        positionJumpMap.put(17,79);
        positionJumpMap.put(46,67);
        positionJumpMap.put(43,85);
        positionJumpMap.put(62,77);
        positionJumpMap.put(70,93);
        positionJumpMap.put(81,98);

        //snakes
        positionJumpMap.put(5,2) ;
        positionJumpMap.put(50,12) ;
        positionJumpMap.put(41,18);
        positionJumpMap.put(44,35) ;
        positionJumpMap.put(95, 65) ;
        positionJumpMap.put(86,80) ;
        positionJumpMap.put(82,61) ;
    }

    public HashMap<Integer, Integer> getBoardPositionJumpMap() {
        return positionJumpMap;
    }

}
