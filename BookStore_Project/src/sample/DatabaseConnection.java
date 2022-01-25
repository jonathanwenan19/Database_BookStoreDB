package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseConnection
{
    public Connection dblink;
    public  static Connection dbConnection() throws SQLException, ClassNotFoundException
    {
        String dbHost = "103.82.242.16";
        String dbPort = "5555";
        String dbUsername = "jonathan";
        String dbPassword = "27442";
        String dbName = "BookStoreDB_JonathanandShravan";
        String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        //String url = "jdbc:mysql://103.82.242.16:5000/jonathanweek1?user=jonathan&password=27442";
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Connection dblink = DriverManager.getConnection(url,dbUsername,dbPassword);
        Connection dblink = DriverManager.getConnection("jdbc:mysql://103.82.242.16:5555/BookStoreDB_JonathanandShravan", dbUsername, dbPassword);


        return dblink;
    }

    public  static ObservableList<available_location> getDataRoom() throws SQLException, ClassNotFoundException {
    Connection db = dbConnection();
    ObservableList<available_location> list = FXCollections.observableArrayList();
    try
    {

        PreparedStatement ps = db.prepareStatement("select * from book_atroom;");
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            list.add(new available_location(rs.getString("room_id"), rs.getString("isle"), rs.getString("floor")));
        }
    }catch(Exception e)
    {

    }
    return list;
    }

    public  static ObservableList<available_genre> getDataGenre() throws SQLException, ClassNotFoundException {
        Connection db = dbConnection();
        ObservableList<available_genre> list = FXCollections.observableArrayList();
        try
        {

            PreparedStatement ps = db.prepareStatement("select * from book_genre;");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                list.add(new available_genre(rs.getString("genre_id"), rs.getString("genre") ));
            }
        }catch(Exception e)
        {

        }
        return list;
    }

    public static ObservableList<book_info> getbookInfo() throws SQLException, ClassNotFoundException
    {
        Connection db = dbConnection();
        ObservableList<book_info> list = FXCollections.observableArrayList();
        try
        {

           // PreparedStatement ps = db.prepareStatement("select book_title.book_id, book_title.book_title, book_pages.pages, book_genre.genre from book_title INNER JOIN book_info ON book_title.book_id = book_info.book_id INNER JOIN book_pages ON book_title.book_id = book_pages.book_id INNER JOIN book_genre ON book_info.genre_id = book_genre.genre_id;");
            PreparedStatement ps = db.prepareStatement("select book_id, book_title, pages, genre from book_identity;");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                list.add(new book_info(rs.getString("book_id"),rs.getString("book_title"), rs.getString("pages"), rs.getString("genre")));
            }
        }catch(Exception e)
        {

        }
        return list;
    }

    public static ObservableList<book_price> getbookPrice() throws SQLException, ClassNotFoundException {
        Connection db = dbConnection();
        ObservableList<book_price> list = FXCollections.observableArrayList();
        try {

            //PreparedStatement ps = db.prepareStatement("select book_title.book_id, book_title.book_title, book_price.price, book_stock.stock from book_title INNER JOIN book_price ON book_title.book_id = book_price.book_id INNER JOIN book_stock ON book_title.book_id = book_stock.book_id;");
            PreparedStatement ps = db.prepareStatement("select book_id, book_title , price, stock from book_identity;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new book_price(rs.getString("book_id"),rs.getString("book_title"),rs.getDouble("price"),rs.getString("stock")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static ObservableList<book_location> getbookLocation() throws SQLException, ClassNotFoundException
    {
        Connection db = dbConnection();
        ObservableList<book_location> list = FXCollections.observableArrayList();
        try {

            PreparedStatement ps = db.prepareStatement("select book_title.book_id, book_title.book_title, book_atroom.floor, book_atroom.isle from book_title INNER JOIN book_info ON book_title.book_id = book_info.book_id INNER JOIN book_atroom ON book_info.room_id = book_atroom.room_id;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new book_location(rs.getString("book_id"), rs.getString("book_title"), rs.getString("floor"), rs.getString("isle")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static ObservableList<book_company> getbookApd() throws SQLException, ClassNotFoundException
    {
        Connection db = dbConnection();
        ObservableList<book_company> list = FXCollections.observableArrayList();
        try {

            PreparedStatement ps = db.prepareStatement("select book_title.book_title, book_author.author_name, book_publisher.publisher,book_distributor.distributor_name from book_title INNER JOIN book_info ON book_title.book_id = book_info.book_id INNER JOIN book_author ON book_info.author_id = book_author.author_id INNER JOIN book_publisher ON book_info.publisher_id = book_publisher.publisher_id INNER JOIN book_distributor ON book_info.distributor_id = book_distributor.distributor_id;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new book_company(rs.getString("book_title"), rs.getString("author_name"),rs.getString("publisher"), rs.getString("distributor_name")));
            }
        } catch (Exception e) {
        }
        return list;
    }
}

 //   select book_title.book_id, book_title.book_title, book_pages.pages, book_genre.genre
   //     -> from book_title
     //   -> INNER JOIN book_info
      //  -> ON book_title.book_id = book_info.book_id
       // -> INNER JOIN book_pages
        //-> ON book_title.book_id = book_pages.book_id
       // -> INNER JOIN book_genre
        //-> ON book_info.genre_id = book_genre.genre_id;

//    select book_title.book_id, book_title.book_title, book_price.price, book_stock.stock
 //   -> from book_title
 //   -> INNER JOIN book_price
  //  -> ON book_title.book_id = book_price.book_id
   // -> INNER JOIN book_stock
   // -> ON book_title.book_id = book_stock.book_id;

  //  select book_title.book_id, book_title.book_title, book_atroom.floor, book_atroom.isle
    //    -> from book_title
      //  -> INNER JOIN book_info
      //  -> ON book_title.book_id = book_info.book_id
      //  -> INNER JOIN book_atroom
      //  -> ON book_info.room_id = book_atroom.room_id
      //  -> ;



 //   select book_title.book_title, book_author.author_name, book_publisher.publisher,book_distributor.distributor_name from book_title
   //     ->  INNER JOIN book_info
     //   ->  ON book_title.book_id = book_info.book_id
     //   -> INNER JOIN book_author
     //   -> ON book_info.author_id = book_author.author_id
      //  -> INNER JOIN book_publisher
      //  -> ON book_info.publisher_id = book_publisher.publisher_id
      //  -> INNER JOIN book_distributor
      //  -> ON book_info.distributor_id = book_distributor.distributor_id;