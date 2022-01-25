package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class registerbook_controller
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    Connection conn;
    @FXML
    private TextField author_text;

    @FXML
    private TextField bookid_text;

    @FXML
    private TextField distributor_text;

    @FXML
    private TextField genreid_text;

    @FXML
    private TextField pagecount_text;

    @FXML
    private TextField price_text;

    @FXML
    private TextField publisher_text;

    @FXML
    private TextField roomid_text;

    @FXML
    private TextField stock_text;

    @FXML
    private TextField title_text;

    @FXML
    private TextField authorid_text;

    @FXML
    private TextField distributorid_text;

    @FXML
    private TextField publisherid_text;


    public void register(ActionEvent event1) throws SQLException, ClassNotFoundException, IOException {
        conn = DatabaseConnection.dbConnection();
        String book_id = bookid_text.getText();
        String title = title_text.getText();
        String genre_id = genreid_text.getText();
        int pagecount = Integer.parseInt(pagecount_text.getText());
        Float price = Float.valueOf(price_text.getText());
        String room_id = roomid_text.getText();
        int stock = Integer.parseInt(stock_text.getText());
        String author = author_text.getText();
        String publisher = publisher_text.getText();
        String distributor = distributor_text.getText();
        String authorid = authorid_text.getText();
        String publisherid = publisherid_text.getText();
        String distributorid = distributorid_text.getText();

        if(book_id.isEmpty() || title.isEmpty() || genre_id.isEmpty() || pagecount == 0 || room_id.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Fill in the data");
            alert.setContentText("PLEASE FILL IN ALL OF THE DATA");
            alert.showAndWait();
        }
        else {

            insert();
        }
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = (Stage)((Node)event1.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Gone to the home scene");
    }


    public void returnhome(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Gone to the home scene");
    }

    private void insert() throws SQLException
    {
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String query1 = "INSERT INTO book_title(book_id,book_title) values('" +bookid_text.getText()+ "','" +title_text.getText()+"');" ;
        String query2 = "INSERT INTO book_pages(book_id,pages) values('" + bookid_text.getText() + "','" + Integer.parseInt(pagecount_text.getText()) +"');" ;
        String query3 = "INSERT INTO book_price(book_id,price) values('" +  bookid_text.getText() + "','" + Float.valueOf(price_text.getText()) + "');";
        String query4 = "INSERT INTO book_stock(book_id,stock) values('" + bookid_text.getText() + "','" + Integer.parseInt(stock_text.getText())+"');";
        String query5 = "INSERT INTO book_author(author_id,author_name) values('"+ authorid_text.getText() + "','" + author_text.getText() +"');" ;
        String query6 = "INSERT INTO book_publisher(publisher_id,publisher) values('"+ publisherid_text.getText() + "','" + publisher_text.getText() +"');";
        String query7 = "INSERT INTO book_distributor(distributor_id,distributor_name) values('" + distributorid_text.getText() + "','" + distributor_text.getText()+"');";
        String query8 = "INSERT INTO book_info(book_id,genre_id,room_id, author_id,publisher_id, distributor_id) values('" + bookid_text.getText() + "','"+ genreid_text.getText()+"','" + roomid_text.getText()+"','"+ authorid_text.getText()+ "','"+ publisherid_text.getText()+"','"+ distributorid_text.getText()+"');";
        String query9 = "insert into book_identity(book_id, book_title, pages, genre, price, stock) select book_title.book_id, book_title.book_title, book_pages.pages, book_genre.genre, book_price.price, book_stock.stock from book_title INNER JOIN book_info ON book_title.book_id = book_info.book_id INNER JOIN book_pages ON book_title.book_id = book_pages.book_id INNER JOIN book_genre ON book_info.genre_id = book_genre.genre_id INNER JOIN book_price ON book_title.book_id = book_price.book_id INNER JOIN book_stock ON book_title.book_id = book_stock.book_id where book_title.book_id =" + bookid_text.getText()+" and book_genre.genre_id =" + genreid_text.getText();
        conn.setAutoCommit(false);
        stmt.addBatch(query1);
        stmt.addBatch(query2);
        stmt.addBatch(query3);
        stmt.addBatch(query4);
        stmt.addBatch(query5);
        stmt.addBatch(query6);
        stmt.addBatch(query7);
        stmt.addBatch(query8);
        stmt.addBatch(query9);
        stmt.executeBatch();
        conn.commit();
    }


}


 //   insert into book_identity(book_id, book_title, pages, genre, price, stock)
 //   -> select book_title.book_id, book_title.book_title, book_pages.pages, book_genre.genre, book_price.price, book_stock.stock from book_title INNER JOIN book_info ON book_title.book_id = book_info.book_id INNER JOIN book_pages ON book_title.book_id = book_pages.book_id INNER JOIN book_genre ON book_info.genre_id = book_genre.genre_id INNER JOIN book_price ON book_title.book_id = book_price.book_id INNER JOIN book_stock ON book_title.book_id = book_stock.book_id
 //           -> where book_title.book_id = 6 and book_genre.genre_id = 2;