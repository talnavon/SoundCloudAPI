
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.logging.Level;


public class Results {

    private Hashtable<String, SearchResult> resultByTitle;
    private Hashtable<String, SearchResult> resultByURL;
    private Hashtable<Integer, SearchResult> resultByID;
    private ArrayList<String> sortedList;
    private static volatile Results results;

    private Results(){
        this.resultByTitle = new Hashtable<String, SearchResult>();
        this.resultByURL = new Hashtable<String, SearchResult>();
        this.resultByID = new Hashtable<Integer, SearchResult>();

    }

    public static Results getInstance(){
        if (results != null ) return results;
        synchronized(Results.class){
            if (results == null )
                results = new Results();
        }
        return results;
    }


    public void sortByTitle(){
        resultByTitle.keySet();
        sortedList = new ArrayList<String>(resultByTitle.keySet());
        Collections.sort(sortedList);
    }

    public void printResults(){
        for (String aSortedList : sortedList) {
            SoundCloudAPILogger.log(Level.INFO, resultByTitle.get(aSortedList).toString());
        }
    }

    public void removeById (Integer id){
        SearchResult sr = resultByID.remove(id);
        resultByURL.remove(sr.getUrl());
        resultByTitle.remove(sr.getTitle());
    }

    public void removeByURL (String url){
        SearchResult sr = resultByURL.remove(url);
        resultByID.remove(sr.getId());
        resultByTitle.remove(sr.getTitle());
    }

    public void addTitle(String title, SearchResult searchResult){
        this.resultByTitle.put(title, searchResult);
    }
    public void addId(Integer id, SearchResult searchResult){
        this.resultByID.put(id, searchResult);
    }
    public void addUrl(String url, SearchResult searchResult){
        this.resultByURL.put(url, searchResult);
    }

    public Hashtable<String, SearchResult> getResultByTitle() {
        return resultByTitle;
    }

    public Hashtable<String, SearchResult> getResultByURL() {
        return resultByURL;
    }

    public Hashtable<Integer, SearchResult> getResultByID() {
        return resultByID;
    }
}
