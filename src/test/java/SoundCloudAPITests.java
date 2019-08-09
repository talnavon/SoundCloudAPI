import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SoundCloudAPITests {
    public SoundCloudAPI soundCloudAPI;
    public Results results;

    @Before
    public void setUp() throws Exception {
        String url1 = "http://api.soundcloud.com/tracks/?q=pixes&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";
        String url2 = "http://api.soundcloud.com/tracks/?q=britney&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";
        String url3 = "http://api.soundcloud.com/tracks/?q=maroon5&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";
        String url4 = "http://api.soundcloud.com/tracks/?q=beyonce&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";
        String url5 = "http://api.soundcloud.com/tracks/?q=darwish&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";
        ArrayList<String> urls = new ArrayList<String>();
        urls.add(url1);
        urls.add(url2);
        urls.add(url3);
        urls.add(url4);
        urls.add(url5);
        soundCloudAPI = new SoundCloudAPI(urls);
        soundCloudAPI.runRequests();
        results = Results.getInstance();
        soundCloudAPI.sortByTitle();
        soundCloudAPI.printResults();
    }

    @Test
    public void testRemoveByID(){
        assertEquals(results.getResultByID().containsKey(79356931), true);
        soundCloudAPI.removeByID(79356931);
        assertEquals(results.getResultByID().containsKey(79356931), false);
    }

    @Test
    public void testRemoveByURL(){
        assertEquals(results.getResultByURL().containsKey("https://soundcloud.com/laura-guerrero/britney-spears-toxic"), true);
        soundCloudAPI.removeByURL("https://soundcloud.com/laura-guerrero/britney-spears-toxic");
        assertEquals(results.getResultByURL().containsKey("https://soundcloud.com/laura-guerrero/britney-spears-toxic"), false);
    }






}
