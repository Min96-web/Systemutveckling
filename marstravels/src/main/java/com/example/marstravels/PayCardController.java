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
import javafx.stage.Stage;

import java.io.IOException;

public class PayCardController {
    @FXML
    private Button btn_Accept;

    @FXML
    private Button btn_Event;

    @FXML
    private Button btn_Restaurant;

    @FXML
    private Button btn_Room;

    @FXML
    private ImageView imgbtn_Cart;

    @FXML
    private ImageView imgbtn_LogIn;

    @FXML
    private ImageView imgbtn_Logo;

    @FXML
    private TextField txtbox_Amount;

    @FXML
    private TextField txtbox_CustomerID;

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
    @FXML
    public void addAmount () {
        ShoppingCart cart = new ShoppingCart();
        FileHandler cartAdder = new FileHandler(); //tror inte vi behöver denna -haru
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);

        if(txtbox_Amount.getText().isEmpty() || txtbox_CustomerID.getText().isEmpty()) {
            alert.setTitle("Error: Fyll i kundnummer & belopp");
            alert.setHeaderText("Error: Ange kundnummer & belopp");
            alert.showAndWait();
        }
        else{
            try {
                if (Integer.parseInt(txtbox_Amount.getText()) < 20000) {
                    alert.setTitle("Error: Fel belopp");
                    alert.setHeaderText("Error: Skriv in minst 20 000 kr");
                    alert.showAndWait();
                } else {
                    Integer.parseInt(txtbox_Amount.getText());
                    cart.addItem("8;" + txtbox_CustomerID.getText().replaceAll(" ", "") + ";" + txtbox_Amount.getText().replaceAll(" ", ""));
                    alertInfo.setTitle("Inlagd");
                    alertInfo.setHeaderText(txtbox_Amount.getText() + " inlagd");
                    alertInfo.showAndWait();
                }
                /*gammal kod med FileHandler*/ //cartAdder.write("5;" + txtbox_CustomerID.getText().replaceAll(" ", "") + ";" + txtbox_Amount.getText().replaceAll(" ", ""), "src/main/java/com/example/marstravels/TempKundvagn.txt");
            }
            catch (NumberFormatException e) {
                alert.setTitle("Error: Måste vara nummer");
                alert.setHeaderText("Error: Måste vara nummer.");
                alert.showAndWait();
            }
        }
    }
}
