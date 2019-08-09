
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String url1 = "http://api.soundcloud.com/tracks/?q=pixes&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";
        String url2 = "http://api.soundcloud.com/tracks/?q=britney&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";
        String url3 = "http://api.soundcloud.com/tracks/?q=maroon5&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";

        ArrayList<String> urls = new ArrayList<String>();
        urls.add(url1);
        urls.add(url2);
        urls.add(url3);

        SoundCloudAPI api = new SoundCloudAPI(urls);
        api.runRequests();
        api.sortByTitle();
        api.printResults();

    }




}
