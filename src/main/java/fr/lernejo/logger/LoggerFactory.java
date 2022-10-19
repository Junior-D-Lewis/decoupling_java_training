package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        return new ContextualLogger(name,  new FileLogger("C:\\Users\\junio\\OneDrive\\Desktop\\Gatien\\ESIEA\\Conception\\TP3\\decoupling_java_training\\log.txt"));
    }
   // FileLogger fileLogger = new FileLogger("C:\\Users\\junio\\OneDrive\\Desktop\\Gatien\\ESIEA\\Conception\\TP3");
}
