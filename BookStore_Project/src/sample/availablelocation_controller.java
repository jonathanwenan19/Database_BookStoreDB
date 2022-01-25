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

public class availablelocation_controller implements Initializable
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableColumn<available_location,String> floor_id;

    @FXML
    private TableColumn<available_location,String> isle_id;

    @FXML
    private TableView<available_location> room_table;

    @FXML
    private TableColumn<available_location,String> roomid_col;
    ObservableList<available_location> room_list;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        floor_id.setCellValueFactory(new PropertyValueFactory<available_location,String>("floor"));
        isle_id.setCellValueFactory(new PropertyValueFactory<available_location,String>("isle"));
        roomid_col.setCellValueFactory(new PropertyValueFactory<available_location,String>("room_id"));

        try {
            room_list = DatabaseConnection.getDataRoom();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        room_table.setItems(room_list);
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

