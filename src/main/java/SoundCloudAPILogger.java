import java.io.IOException;
import java.util.logging.*;


public class SoundCloudAPILogger {
    static Logger logger;
    public Handler fileHandler;
    SimpleFormatter plainText;

    private SoundCloudAPILogger() throws IOException {
        logger = Logger.getLogger(SoundCloudAPILogger.class.getName());
        fileHandler = new FileHandler("SoundCloudAPILog.txt", true);
        plainText = new SimpleFormatter();
        fileHandler.setFormatter(plainText);
        logger.addHandler(fileHandler);
    }

    private static Logger getLogger(){
        if(logger == null){
            try {
                new SoundCloudAPILogger();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return logger;
    }
    public static void log(Level level, String msg){
        getLogger().log(level, msg);
    }
}
