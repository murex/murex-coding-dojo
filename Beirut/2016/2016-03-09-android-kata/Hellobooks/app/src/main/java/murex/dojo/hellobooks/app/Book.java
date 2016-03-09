package murex.dojo.hellobooks.app;


public class Book {
    private String title;
    private String imageUrl;

    public Book(String title, String imageUrl) {
        this.imageUrl = imageUrl;
        this.title = title;
    }

    public String title() {
        return title;
    }

    public String imageUrl() {
        return imageUrl;
    }
}
