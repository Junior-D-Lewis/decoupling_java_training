package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type
    private boolean lowerOrGreater;

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        Scanner sc = new Scanner(System.in);
        long numberGuess = player.askNextGuess();
        if(numberGuess == numberToGuess){
            lowerOrGreater = false;
        }else{
            lowerOrGreater = true;
        }
        player.respond(lowerOrGreater);
        return !lowerOrGreater;
    }

    public void loopUntilPlayerSucceed() {
        //TODO implement me
        do {
            nextRound();
        }while (lowerOrGreater);
    }
}
