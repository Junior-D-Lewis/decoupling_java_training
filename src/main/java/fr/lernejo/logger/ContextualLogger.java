package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{

    public ContextualLogger(String className, Logger logger) {
        this.callerClass = className;
        this.delegateLogger = logger;
    }

    @Override
    public void log(String message) {
        this.delegateLogger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + " " + callerClass + " " + message);
    }

    private final String callerClass;
    private final Logger delegateLogger;

}
