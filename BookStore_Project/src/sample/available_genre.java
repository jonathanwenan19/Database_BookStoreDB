package sample;

public class available_genre
{
    public String genre_id;
    public String genre;

    public available_genre(String genre_id, String genre) {
        this.genre_id = genre_id;
        this.genre = genre;
    }

    public String getGenre_id() {
        return genre_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setBook_id(String genre_id) {
        this.genre_id = genre_id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
