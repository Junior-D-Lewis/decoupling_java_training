package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private static long numberToGuess; //TODO add variable type
    private boolean lowerOrGreater;
    public int[] numbers = new int[100];
    private long first = 0;
    private long last = 99;

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
        for (int i = 0; i<100; i++){
            numbers[i] = i;
        }
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        if (this.player instanceof HumanPlayer){
            long numberGuess = player.askNextGuess();
            if(numberGuess == this.numberToGuess){
                lowerOrGreater = false;
            }else{
                lowerOrGreater = true;
            }
            player.respond(lowerOrGreater);
            return !lowerOrGreater;
        }else {
            int index = (int) player.askNextGuess(first, last);
            while(first <= last){
                if (numbers[index] < this.numberToGuess){
                    lowerOrGreater = true;
                    first = index + 1;
                    return !lowerOrGreater;
                }else if(numbers[index] == this.numberToGuess){
                    lowerOrGreater = false;
                    return !lowerOrGreater;
                }else{
                    lowerOrGreater = true;
                    last = index - 1;
                }
                index = (int)(first + last)/2;
                return !lowerOrGreater;
            }
        }
        return !lowerOrGreater;
    }
    public void loopUntilPlayerSucceed(long long_max_value) {
        //TODO implement me
        long timestampMSAtStart = System.currentTimeMillis();
        int i = 0;
        do {
            nextRound();
            ++i;
        }while (lowerOrGreater & i != long_max_value);
        long timestampMSAtEnd = System.currentTimeMillis();
        if (lowerOrGreater){
            logger.log("Vous n'avez pas trouvé la bonne solution");
        }else {
            logger.log("Bravo! vous avez trouvé la bonne solution");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
        String formatted = sdf.format(new Date(timestampMSAtEnd - timestampMSAtStart));
        System.out.println("Temps écoulé: " + formatted);
    }
}
