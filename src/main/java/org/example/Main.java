package org.example;

import org.example.models.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(1,6,10) ;
        String winner = game.startGame();
        System.out.println("Winner of snakes and Ladder game is " + winner);
    }
}