package sample;

import javafx.fxml.Initializable;
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

public class booklocation_controller implements Initializable
{
    private Stage stage;
    private Scene scene;
    @FXML
    private TableColumn<book_location, String> aisle_col;

    @FXML
    private TableColumn<book_location, String> bookid_col3;

    @FXML
    private TableColumn<book_location, String> booktitle_col3;

    @FXML
    private TableColumn<book_location, String> floor_col;

    @FXML
    private TableView<book_location> location_table;
    ObservableList<book_location> location_list;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        bookid_col3.setCellValueFactory(new PropertyValueFactory<book_location,String>("book_id"));
        booktitle_col3.setCellValueFactory(new PropertyValueFactory<book_location,String>("title"));
        aisle_col.setCellValueFactory(new PropertyValueFactory<book_location,String>("isle"));
        floor_col.setCellValueFactory(new PropertyValueFactory<book_location,String>("floor"));

        try {
            location_list = DatabaseConnection.getbookLocation();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        location_table.setItems(location_list);
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
