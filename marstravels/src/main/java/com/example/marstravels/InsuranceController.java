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

import java.io.File;
import java.io.IOException;

public class InsuranceController {

    @FXML
    private Button btn_Event;

    @FXML
    private Button btn_Hotel;

    @FXML
    private Button btn_Insurance;

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
    private TextField txtfld_InsuranceSumma;

    @FXML
    public void addToCart() {
        ShoppingCart cart = new ShoppingCart();
        FileHandler cartAdder = new FileHandler();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Alert information = new Alert(Alert.AlertType.INFORMATION);

        if (txtfld_InsuranceSumma.getText().isEmpty()) {
            alert.setTitle("Error: Skriv in summa");
            alert.setHeaderText("Error: Skriv in summa.");
            alert.showAndWait();
        }
        else {
            try {
                if (!(Integer.parseInt(txtfld_InsuranceSumma.getText()) == 50000)) {
                    alert.setTitle("Error: Fel belopp");
                    alert.setHeaderText("Error: Du måste skriva in minst 50 000 kr per person");
                    alert.showAndWait();
                    txtfld_InsuranceSumma.setText("0");
                }
                else {
                    Integer.parseInt(txtfld_InsuranceSumma.getText());
                    cart.addItem("7;" + txtfld_InsuranceSumma.getText());
                    information.setTitle("Bekräftelse");
                    information.setHeaderText("Bekräftelse: Du har lagt till din summa i kundvagnen.");
                    information.showAndWait();



                }
              /*gammal kod med FileHandler*/  //cartAdder.write("6;" + txtfld_InsuranceSumma.getText(), "src/main/java/com/example/marstravels/TempKundvagn.txt");
            }
            catch (NumberFormatException e) {
                alert.setTitle("Error: Måste vara nummer");
                alert.setHeaderText("Error: Måste vara nummer.");
                alert.showAndWait();
            }

        }

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


