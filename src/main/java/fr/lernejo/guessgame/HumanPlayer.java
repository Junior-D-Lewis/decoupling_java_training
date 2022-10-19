package fr.lernejo.guessgame;

import fr.lernejo.logger.*;

import java.util.Scanner;

public class HumanPlayer implements  Player{

    @Override
    public long askNextGuess() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Veuillez deviner: ");
        return sc.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        final Logger logger = LoggerFactory.getLogger("player");
        if (lowerOrGreater){
            logger.log("plus grand ou plus petit");
        }else {
            logger.log("Egal, vous avez réussit");
        }

    }
}
