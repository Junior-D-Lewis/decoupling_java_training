package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args){
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
        Logger logger = LoggerFactory.getLogger("Launcher");

        try {
            if (args[0].equals("-interactive")){
                HumanPlayer player = new HumanPlayer();
                Simulation simulation = new Simulation(player);
                simulation.initialize(randomNumber);
                simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
            } else if (args[0].equals("-auto") && args[1].matches("[+-]?\\d*(\\.\\d+)?")) {
                ComputerPlayer player = new ComputerPlayer();
                Simulation simulation = new Simulation(player);
                simulation.initialize(randomNumber);
                simulation.loopUntilPlayerSucceed(Long.parseLong(args[1]));
            }else {
                logger.log("Afin de lancer une partie veuillez suivre les étapes!");
                logger.log("Si vous êtes un HumanPlayer, veuillez passer un seul paramètre '-interactive");
                logger.log("Si vous êtes un ComputerPlayer, veuillez passer 02 parametres le premier: '-auto' et le second: un nombre qui correspondra au nombre d'ittération");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}
