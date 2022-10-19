package fr.lernejo.guessgame;

import fr.lernejo.logger.*;

import java.util.Scanner;

public class HumanPlayer implements  Player{

    @Override
    public long askNextGuess(long first, long lass) {
        return 0;
    }

    @Override
    public long askNextGuess() {
        Scanner sc = new Scanner(System.in);
        logger.log("Veuillez deviner: ");
        try {
            return sc.nextLong();
        }catch (NumberFormatException e){
            logger.log(e.getMessage());
        }
        return 0;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater){
            logger.log("plus grand ou plus petit");
        }else {
            logger.log("Egal");
        }
    }
    private final Logger logger = LoggerFactory.getLogger("player");

}
