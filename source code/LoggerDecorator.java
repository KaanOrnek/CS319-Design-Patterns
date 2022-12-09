public class LoggerDecorator implements Logger {
    private Logger logger;

    LoggerDecorator(Logger logger){
        this.logger = logger;
    }

    @Override
    public void log(String text) {
        logger.log(text);
    }
}
