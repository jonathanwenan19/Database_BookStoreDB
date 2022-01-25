package sample;

public class book_price
{
    public String book_id;
    public String title;
    public Double price;
    public String stock;

    public book_price(String book_id, String title, Double price, String stock) {
        this.book_id = book_id;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getBook_id() {
        return book_id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public String getStock() {
        return stock;
    }
}
