package fr.lernejo.logger;

public class LoggerFactory {

    public static ConsoleLogger getLogger(String name) {
        return new ConsoleLogger();
    }
}
