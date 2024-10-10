package com.example.marstravels;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class RoomController {

    public Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private Button btn_CartEconomy;

    @FXML
    private Button btn_CartInside;

    @FXML
    private Button btn_CartSpaceSide;

    @FXML
    private Button btn_CartSvit;

    @FXML
    private Button btn_Event;

    @FXML
    private Button btn_Restaurant;

    @FXML
    private Button btn_Room;

    @FXML
    private Button btn_Hotel;

    @FXML
    private ImageView imgbtn_Cart;

    @FXML
    private ImageView imgbtn_LogIn;

    @FXML
    private ImageView imgbtn_Logo;

    @FXML
    public void openCartView (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MarsTravelApplication.class.getResource("CartView.fxml"));
        Parent cartParent = loader.load();
        Scene chosenScene = new Scene(cartParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Cart");
        window.setScene(chosenScene);
        window.show();
    }
    @FXML
    public void openEventView (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MarsTravelApplication.class.getResource("EventView.fxml"));
        Parent eventParent = loader.load();
        Scene chosenScene = new Scene(eventParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Event");
        window.setScene(chosenScene);
        window.show();
    }
    @FXML
    public void openHotelView (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MarsTravelApplication.class.getResource("HotelView.fxml"));
        Parent hotelParent = loader.load();
        Scene chosenScene = new Scene(hotelParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Hotel");
        window.setScene(chosenScene);
        window.show();
    }
    @FXML
    public void openRoomView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MarsTravelApplication.class.getResource("RoomToMarsView.fxml"));
        Parent roomParent = loader.load();
        Scene chosenScene = new Scene(roomParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Book a Room");
        window.setScene(chosenScene);
        window.show();
    }
    @FXML
    public void openRestaurantView (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MarsTravelApplication.class.getResource("RestaurantView.fxml"));
        Parent restaurantView = loader.load();
        Scene chosenScene = new Scene(restaurantView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Restaurant");
        window.setScene(chosenScene);
        window.show();
    }

    @FXML public void addEconomy (){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("1;Economy");
        alert.setTitle("Vald");
        alert.setHeaderText("Economy är vald");
        alert.showAndWait();
    }
    @FXML public void addSvit (){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("1;Svit");
        alert.setTitle("Vald");
        alert.setHeaderText("Svit är vald");
        alert.showAndWait();
    }
    @FXML public void addSpaceside (){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("1;Spaceside");
        alert.setTitle("Vald");
        alert.setHeaderText("Spaceside är vald");
        alert.showAndWait();
    }
    @FXML public void addInside (){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("1;Inside");
        alert.setTitle("Vald");
        alert.setHeaderText("Inside är vald");
        alert.showAndWait();
    }
}
