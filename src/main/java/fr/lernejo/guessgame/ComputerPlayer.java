package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{
    @Override
    public long askNextGuess(long first, long lass) {
        return (first + lass)/2;
    }

    @Override
    public long askNextGuess() {
        return 0;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        final Logger logger = LoggerFactory.getLogger("ComputerPlayer");
        if (lowerOrGreater){
            logger.log("plus grand ou plus petit");
        }else {
            logger.log("Egal, vous avez réussit");
        }
    }
}
