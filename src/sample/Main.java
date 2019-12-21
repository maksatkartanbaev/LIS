package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.database.DatabaseHandler;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ui/listbook/ListBook.fxml"));
        primaryStage.setTitle("Library Information System - Sign in");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);


//        String url = "jdbc:mysql://localhost:3306/javabase";
//        String username = "java";
//        String password = "password";
//
//        System.out.println("Connecting database...");

//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            System.out.println("Database connected!");
//            Statement st = connection.createStatement();
//            st.executeUpdate("INSERT INTO publisher (name, address) VALUES ('Maksat Kartanbaev', 'Bokonbaeva')");
//            st.executeUpdate("INSERT INTO publisher_contact_no(contact_no) VALUE ('+996703987456')");
//            ResultSet rs = st.executeQuery("SELECT * from publisher AND SELECT contact_no from publisher_contact_no");
//            while (rs.next()){
//                int id = rs.getInt(1);
//                String address = rs.getString(2);
//                String name = rs.getString(3);
//                String contact_no = rs.getString(4);
//                System.out.format("%s, %s, %s, %s\n", id, name, address, contact_no);
//            }
//        } catch (SQLException e) {
//            throw new IllegalStateException("Cannot connect the database!", e);
//        }


    }

}
