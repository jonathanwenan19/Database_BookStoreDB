package sample;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class Controller
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void showallbooks(ActionEvent event) throws IOException
    {
        Parent root =FXMLLoader.load(getClass().getResource(""));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Gone to the 2nd scene");
    }
    public void returnhome(ActionEvent event) throws IOException
    {
        Parent root =FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Gone to the 3rd scene");
    }
    public void showbook_info(ActionEvent event) throws IOException
    {
        Parent root =FXMLLoader.load(getClass().getResource("Book_info.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Gone to the 3rd scene");
    }
    public void showbook_price(ActionEvent event) throws IOException
    {
        Parent root =FXMLLoader.load(getClass().getResource("Book_Price.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Gone to the 4th scene");
    }

    public void show_booklocation(ActionEvent event) throws IOException
    {
        Parent root =FXMLLoader.load(getClass().getResource("Book_Location.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Gone to the 5th scene");
    }

    public void show_availablegenre(ActionEvent event) throws IOException
    {
        Parent root =FXMLLoader.load(getClass().getResource("Available_genre.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Gone to the 6th scene");
    }

    public void show_registerbook(ActionEvent event) throws IOException
    {
        Parent root =FXMLLoader.load(getClass().getResource("register_book.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Gone to the 7th scene");
    }

    public void show_availablelocations(ActionEvent event) throws IOException
    {
        Parent root =FXMLLoader.load(getClass().getResource("available_location.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Gone to the 8th scene");
    }

    public void show_bookapd(ActionEvent event) throws IOException
    {
        Parent root =FXMLLoader.load(getClass().getResource("show_bookapd.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Gone to the 9th scene");
    }
}
