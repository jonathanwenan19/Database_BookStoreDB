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
public class book_pricecontroller implements Initializable
{
    private Stage stage;
    private Scene scene;
    @FXML
    private TableColumn<book_price, String> bookid_col2;

    @FXML
    private TableColumn<book_price, Double> price_col;

    @FXML
    private TableView<book_price> pricestock_table;

    @FXML
    private TableColumn<book_price, String> stock_col;

    @FXML
    private TableColumn<book_price, String> title_col2;

    ObservableList<book_price> price_list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        bookid_col2.setCellValueFactory(new PropertyValueFactory<book_price,String>("book_id"));
        title_col2.setCellValueFactory(new PropertyValueFactory<book_price,String>("title"));
        price_col.setCellValueFactory(new PropertyValueFactory<book_price,Double>("price"));
        stock_col.setCellValueFactory(new PropertyValueFactory<book_price,String>("stock"));

        try {
            price_list = DatabaseConnection.getbookPrice();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        pricestock_table.setItems(price_list);
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
