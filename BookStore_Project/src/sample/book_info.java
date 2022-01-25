package sample;

public class book_info
{
    public String book_id;
    public String book_title;
    public String page;
    public String genre;

    public book_info(String book_id, String book_title, String page, String genre) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.page = page;
        this.genre = genre;
    }

    public String getBook_id() {
        return book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public String getPage() {
        return page;
    }

    public String getGenre() {
        return genre;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
