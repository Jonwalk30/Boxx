package com.red.boxx;
import static com.sun.tools.javac.util.StringUtils.toUpperCase;

public class Logger {

    private Boolean debuggingMode;

    public Logger(Boolean debuggingMode) {
        setDebuggingMode(debuggingMode);
    }

    public void log(LoggingType type, String insideMethod, String message) {

        // TODO: Only want to log debug messages if debugging mode is on?

        String typeAsString;

        if (type == LoggingType.INFO) {
            typeAsString = "INFO";
        } else if (type == LoggingType.DEBUG) {
            typeAsString = "DEBUG";
        } else if (type == LoggingType.WARNING) {
            typeAsString = "WARNING";
        } else /* (type == LoggingType.ERROR) */ {
            typeAsString = "ERROR";
        }

        System.out.println(typeAsString + ": " + toUpperCase(insideMethod) + " - " + message);

    }


    public Boolean getDebuggingMode() {
        return debuggingMode;
    }

    public void setDebuggingMode(Boolean debuggingMode) {
        this.debuggingMode = debuggingMode;
    }

    public enum LoggingType {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }
}