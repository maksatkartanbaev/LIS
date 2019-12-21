package sample.ui.addbook;

import com.sun.glass.ui.Window;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.database.DatabaseHandler;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddBookController implements Initializable {
    @FXML
    private TextField bookISBN;
    @FXML
    private TextField bookName;
    @FXML
    private TextField bookAuthor;
    @FXML
    private TextField bookPublisher;
    @FXML
    private Button addButton;
    @FXML
    private Button cancelButton;
    @FXML
    private AnchorPane rootPane;

    DatabaseHandler databaseHandler;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        databaseHandler = new DatabaseHandler();
    }


    public void addBook(ActionEvent actionEvent) throws SQLException {
        String ISBN = bookISBN.getText();
        String name = bookName.getText();
        String author = bookAuthor.getText();
        String publisher = bookPublisher.getText();

        if(ISBN.isEmpty() || name.isEmpty() || author.isEmpty() || publisher.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Why are you doing this to me?");
            alert.setContentText("Please fill all fields");
            alert.showAndWait();
            return;
        }

        String qu = "INSERT INTO book VALUES(" +
                "'" + ISBN + "'," +
                "'" + name + "'," +
                "'" + author + "'," +
                "'" + publisher + "'," +
                "" + true + "" +
                ")";
        System.out.println(qu);
        if(databaseHandler.execAction(qu)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Good job, boss!");
            alert.setContentText("Book has been added!");
            alert.showAndWait();
        } else //Error
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("We got a problem!");
            alert.setContentText("Something went wrong, boss!");
            alert.showAndWait();
        }

    }

    public void cancel(ActionEvent event){
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }
}
