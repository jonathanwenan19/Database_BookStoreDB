package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class book_infocontroller implements Initializable
{
    private Stage stage;
    private Scene scene;
    @FXML
    private TableColumn<book_info, String> bookid_col;

    @FXML
    private TableView<book_info> bookinfo_table;

    @FXML
    private TableColumn<book_info, String> booktitle_col;

    @FXML
    private TableColumn<book_info, String> genre_col;

    @FXML
    private TableColumn<book_info, String> page_col;

    ObservableList<book_info> bookinfo_list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        bookid_col.setCellValueFactory(new PropertyValueFactory<book_info,String>("book_id"));
        booktitle_col.setCellValueFactory(new PropertyValueFactory<book_info,String>("book_title"));
        page_col.setCellValueFactory(new PropertyValueFactory<book_info,String>("Page"));
        genre_col.setCellValueFactory(new PropertyValueFactory<book_info,String>("genre"));

        try {
            bookinfo_list = DatabaseConnection.getbookInfo();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        bookinfo_table.setItems(bookinfo_list);
    }

    public void returnhome(ActionEvent event) throws IOException
    {
        Parent root =FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Gone to the home scene");
    }
}
