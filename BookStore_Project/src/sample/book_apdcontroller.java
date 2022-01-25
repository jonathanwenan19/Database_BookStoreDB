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

public class book_apdcontroller implements Initializable
{
    private Stage stage;
    private Scene scene;
    @FXML
    private TableView<book_company> APD_table;

    @FXML
    private TableColumn<book_company, String> author_col4;

    @FXML
    private TableColumn<book_company, String > distributor_col;

    @FXML
    private TableColumn<book_company, String> publisher_col;

    @FXML
    private TableColumn<book_company, String> title_col4;
    ObservableList<book_company> company_list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        author_col4.setCellValueFactory(new PropertyValueFactory<book_company,String>("author"));
        title_col4.setCellValueFactory(new PropertyValueFactory<book_company,String>("title"));
        publisher_col.setCellValueFactory(new PropertyValueFactory<book_company,String>("publisher"));
        distributor_col.setCellValueFactory(new PropertyValueFactory<book_company,String>("distributor"));

        try {
            company_list = DatabaseConnection.getbookApd();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        APD_table.setItems(company_list);
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
