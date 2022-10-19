package fr.lernejo.logger;

public class CompositeLogger implements Logger{
    public CompositeLogger(Logger logger, Logger logger2) {
        this.logger = logger;
        this.logger2 = logger2;
    }

    @Override
    public void log(String message) {
        logger.log(message);
        logger2.log(message);
    }

    private final Logger logger;
    private final Logger logger2;
}
