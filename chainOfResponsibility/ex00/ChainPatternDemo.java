package patterns.chainOfresponsibility.ex00;

/**
 * Created by scream on 23.07.2016.
 */
public class ChainPatternDemo {

    private static AbstractLogger getChinOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {

        AbstractLogger chainLogger = getChinOfLoggers();

        chainLogger.logMessage(AbstractLogger.INFO, "simple INFO");
        chainLogger.logMessage(AbstractLogger.DEBUG, "this is an DEBUG information");
        chainLogger.logMessage(AbstractLogger.ERROR, "ERROR message!");
    }
}
