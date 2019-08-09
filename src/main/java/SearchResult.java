
public class SearchResult {

    private Integer id;
    private String title;
    private String url;
    private Object user;

    public SearchResult(int id, String title, String url, Object user) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.user = user;
    }

    public String toString(){
        return "{" +
                String.format("id: %d, ", id) +
                String.format("title: %s, ", title) +
                String.format("url: %s, ", url) +
                String.format("user: %s ", user.toString()) +
                "}";
    }

    public String getUrl() {
        return url;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
