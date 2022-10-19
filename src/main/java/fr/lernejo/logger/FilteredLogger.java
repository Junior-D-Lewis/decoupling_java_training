package fr.lernejo.logger;

import java.util.function.Predicate;

public class FilteredLogger implements Logger {

    public FilteredLogger(Logger delegate, Predicate<String> condition) {
        this.delegate = delegate;
        this.condition = condition;
    }

    @Override
    public void log(String message) {
        if (condition.test(message))
            delegate.log(message);
    }
    private final Logger delegate;
    private final Predicate<String> condition;
}
