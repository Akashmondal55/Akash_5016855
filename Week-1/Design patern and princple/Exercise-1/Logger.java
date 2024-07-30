public class Logger {
    private static Logger instance;
    private String logLevel;

    private Logger() {
        // Private constructor to prevent instantiation
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setLogLevel(String level) {
        this.logLevel = level;
    }

    public void log(String message) {
        System.out.println(logLevel + ": " + message);
    }
}