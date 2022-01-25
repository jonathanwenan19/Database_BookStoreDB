package sample;

public class book_company
{
    public String title;
    public String author;
    public String publisher;
    public String distributor;

    public book_company(String title, String author, String publisher, String distributor) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.distributor = distributor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDistributor() {
        return distributor;
    }
}
