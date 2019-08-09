import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class SoundCloudAPI {
    private static final int MAX_TREADS = 3;
    private ArrayList<String> urls;
    private ExecutorService pool;
    private Results results;


    public SoundCloudAPI(ArrayList<String> urls) {
        this.urls = urls;
        pool = Executors.newFixedThreadPool(MAX_TREADS);
        results = Results.getInstance();
    }

    public void runRequests() {
        for (String url : urls){
            Runnable task = new APITask(url);
            pool.execute(task);
        }
        pool.shutdown();
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void removeByID(Integer id){results.removeById(id);}

    public void removeByURL(String url){results.removeByURL(url);}

    public void sortByTitle(){
        results.sortByTitle();
    }

    public void printResults(){
        results.printResults();
    }


}
