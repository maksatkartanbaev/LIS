package sample.ui.listbook;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sample.Book;
import sample.database.DatabaseHandler;
import sample.ui.addbook.AddBookController;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListBookController implements Initializable {

    ObservableList<Book> list = FXCollections.observableArrayList();

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Book> TableView;
    @FXML
    private TableColumn<Book, String> ISBNCol;
    @FXML
    private TableColumn<Book, String> TitleCol;
    @FXML
    private TableColumn<Book, String> AuthorCol;
    @FXML
    private TableColumn<Book, String> PublisherCol;
    @FXML
    private TableColumn<Book, Integer> AvailabilityCol;
    @FXML
    private TableColumn<Book, Float> RatingCol;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initCol();
        loadData();
    }

    private void loadData() {
        DatabaseHandler handler = new DatabaseHandler();
        String qu = "SELECT * FROM book";
        ResultSet rs = handler.execQuery(qu);
        try{
            while (rs.next()){
                String ISBN = rs.getString("ISBN");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                Integer availability = rs.getInt("availability");
                Float rating = rs.getFloat("rating");

                list.add(new Book(ISBN, title, author, publisher, availability, rating));
            }
        } catch (SQLException ex){
            Logger.getLogger(AddBookController.class.getName()).log(Level.SEVERE, null, ex);
        }

        TableView.getItems().setAll(list);
    }

    private void initCol() {
        ISBNCol.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        TitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        AuthorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        PublisherCol.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        AvailabilityCol.setCellValueFactory(new PropertyValueFactory<>("availability"));
        RatingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
    }

}
