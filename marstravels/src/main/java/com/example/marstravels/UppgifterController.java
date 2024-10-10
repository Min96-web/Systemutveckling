package com.example.marstravels;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UppgifterController {

    /*
    String persnr = "19930303-0303";
    Resenär person = new Resenär(persnr, "Jenny","Pettersson","Visby 11","jennypetter@gmail.com","Medicin");
    */

    public void addPerson(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Resenär person = new Resenär(
                txtbox_CustomerID.getText(),
                txtbox_Firstname.getText(),
                txtbox_Lastname.getText(),
                txtbox_Adress.getText(),
                txtbox_Post.getText(),
                txtbox_Health.getText()
        );
        SqlQuery sql = new SqlQuery();

        sql.insertResenär(person.getPersonnr(), person.getFname(), person.getLname(), person.getAdress(), person.getEpost(), person.getHälsodetaljer());

        alert.setTitle("Inlagd");
        alert.setHeaderText("Information sparad");
        alert.showAndWait();



        System.out.println(person.getPersonnr()); //test att det funkar
        //INSERT INTO testresenär (personnr) VALUES (oerson.getPersonnr())


    }

    @FXML
    private Button btn_Event;

    @FXML
    private Button btn_Hotel;

    @FXML
    private Button btn_Restaurant;

    @FXML
    private Button btn_Room;

    @FXML
    private Button btn_Save;

    @FXML
    private ImageView imgbtn_Cart;

    @FXML
    private ImageView imgbtn_LogIn;

    @FXML
    private ImageView imgbtn_Logo;

    @FXML
    private AnchorPane txtbox_;

    @FXML
    private TextField txtbox_Adress;

    @FXML
    private TextField txtbox_CustomerID;

    @FXML
    private TextField txtbox_Firstname;

    @FXML
    private TextField txtbox_Health;

    @FXML
    private TextField txtbox_Lastname;

    @FXML
    private TextField txtbox_Post;

    @FXML
    void saveCustomer(ActionEvent event) {

    }



    @FXML
    public void openCartView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MarsTravelApplication.class.getResource("CartView.fxml"));
        Parent cartParent = loader.load();
        Scene chosenScene = new Scene(cartParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Cart");
        window.setScene(chosenScene);
        window.show();
    }

    @FXML
    public void openEventView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MarsTravelApplication.class.getResource("EventView.fxml"));
        Parent eventParent = loader.load();
        Scene chosenScene = new Scene(eventParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Event");
        window.setScene(chosenScene);
        window.show();
    }

    @FXML
    public void openHotelView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MarsTravelApplication.class.getResource("HotelView.fxml"));
        Parent hotelParent = loader.load();
        Scene chosenScene = new Scene(hotelParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Hotel");
        window.setScene(chosenScene);
        window.show();
    }

    @FXML
    public void openRoomView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MarsTravelApplication.class.getResource("RoomToMarsView.fxml"));
        Parent roomParent = loader.load();
        Scene chosenScene = new Scene(roomParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Book a Room");
        window.setScene(chosenScene);
        window.show();
    }

    @FXML
    public void openRestaurantView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MarsTravelApplication.class.getResource("RestaurantView.fxml"));
        Parent restaurantView = loader.load();
        Scene chosenScene = new Scene(restaurantView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Restaurant");
        window.setScene(chosenScene);
        window.show();
    }


}

