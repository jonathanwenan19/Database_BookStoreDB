package sample;

public class addStudentclass
{
    public String bookid;
    public String title;
    public String price;
    public String roomid;
    public String genreid;
    public String pagecount;

    public addStudentclass(String bookid, String title, String price, String roomid, String genreid, String pagecount) {
        this.bookid = bookid;
        this.title = title;
        this.price = price;
        this.roomid = roomid;
        this.genreid = genreid;
        this.pagecount = pagecount;
    }

    public String getBookid() {
        return bookid;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getRoomid() {
        return roomid;
    }

    public String getGenreid() {
        return genreid;
    }

    public String getPagecount() {
        return pagecount;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public void setGenreid(String genreid) {
        this.genreid = genreid;
    }

    public void setPagecount(String pagecount) {
        this.pagecount = pagecount;
    }
}
