package framework.logger;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;

public class Log {
    private static String currentLogDir;
    private static FileAppender currentFileAppender;

    private Log() {

    }

    public synchronized static void info(String message) {
        Logger.getLogger(getCallingClassName()).info(message);
    }

    public synchronized static void info(String template, Object... args) {
        info(String.format(template, args));
    }

    public synchronized static void info(Object message) {
        info(message.toString());
    }


    public synchronized static void warn(String message) {
        Logger.getLogger(getCallingClassName()).warn(message);
    }

    public synchronized static void warn(String template, Object... args) {
        warn(String.format(template, args));
    }

    public synchronized static void warn(Object message) {
        warn(message.toString());
    }


    public synchronized static void error(String message) {
        Logger.getLogger(getCallingClassName()).error(message);
    }

    public synchronized static void error(String template, Object... args) {
        error(String.format(template, args));
    }

    public synchronized static void error(Object message) {
        error(message.toString());
    }

    public synchronized static void error(String message, Exception e) {
        error(message + '\n' + e.getLocalizedMessage());
    }

    public synchronized static void debug(String message) {
        Logger.getLogger(getCallingClassName()).debug(message);
    }

    public synchronized static void debug(String template, Object... args) {
        debug(String.format(template, args));
    }

    public synchronized static void debug(Object message) {
        debug(message.toString());
    }

    private static String getCallingClassName() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String fullClassName = stackTrace[2].getClassName();
        return fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
    }
}
