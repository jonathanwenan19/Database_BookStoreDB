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


public class availablegenre_controller implements Initializable
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<available_genre> genre_table;

    @FXML
    private TableColumn<available_genre, String> genreid_col;

    @FXML
    private TableColumn<available_genre, String> genrename_col;

    ObservableList<available_genre> genre_list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        genreid_col.setCellValueFactory(new PropertyValueFactory<available_genre,String>("genre_id"));
        genrename_col.setCellValueFactory(new PropertyValueFactory<available_genre,String>("genre"));


        try {
            genre_list = DatabaseConnection.getDataGenre();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        genre_table.setItems(genre_list);
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
