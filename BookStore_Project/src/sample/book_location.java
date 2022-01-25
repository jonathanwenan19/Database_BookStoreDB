package sample;

public class book_location
{
    public String book_id;
    public String title;
    public String floor;
    public String isle;

    public book_location(String book_id, String title, String floor, String isle) {
        this.book_id = book_id;
        this.floor = floor;
        this.isle = isle;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getFloor() {
        return floor;
    }

    public String getIsle() {
        return isle;
    }



    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setIsle(String isle) {
        this.isle = isle;
    }
}
