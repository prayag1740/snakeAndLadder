package org.example.models;

import java.util.Random;

public class Dice {

    private final Integer diceNo ;

    public Dice(Integer diceNo) {
        this.diceNo = diceNo;
    }

    public Integer rollDice() {
        Random randomNo = new Random() ;
        Integer randomRoll = randomNo.nextInt(6) + 1 ;
        return (randomRoll*this.diceNo) ;
    }


}
