package com.example.marstravels;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartController {
  //Engla: för att bara välja ett av alternativen till och från//
    final ToggleGroup group = new ToggleGroup();

    @FXML
    private void initialize() {
        ShoppingCart cart = new ShoppingCart();
        List<String> list = cart.loadCart();

        if(!list.isEmpty()) {
            for (String s : list) {
                cartList.appendText(s + "\n");
            }
        }
        else {
            cartList.setText("Kundvagnen är tom");
        }

        rbtn_Från.setToggleGroup(group);
        rbtn_Till.setToggleGroup(group);

    }

    @FXML
    private TextArea cartList;

    @FXML
    private Button btn_Event;

    @FXML
    private Button btn_Restaurant;

    @FXML
    private Button btn_Room;

    @FXML
    private Button btn_Hotel;

    @FXML
    private ImageView imgbtn_CartInBtn;

    @FXML
    private ImageView imgbtn_LogIn;

    @FXML
    private ImageView imgbtn_Logo;

    @FXML
    private Button btn_InsuranceConnection;

    @FXML
    private Button btn_PaycardConnection;

    @FXML
    private Button btn_confirm;

    @FXML
    private RadioButton rbtn_Från;

    @FXML
    private RadioButton rbtn_Till;


    @FXML
    private TextFlow txtf_test;

    @FXML
    public void openUppgifterView (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MarsTravelApplication.class.getResource("UppgifterView.fxml"));
        Parent cartParent = loader.load();
        Scene chosenScene = new Scene(cartParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Information");
        window.setScene(chosenScene);
        window.show();
    }


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
// Engla lägger till openInsuranceView för knapp kopplad från bekräftelsesidan//
@FXML
public void openInsuranceView (ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(MarsTravelApplication.class.getResource("InsuranceView.fxml"));
    Parent cartParent = loader.load();
    Scene chosenScene = new Scene(cartParent);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setTitle("Insurance");
    window.setScene(chosenScene);
    window.show();
}
// Lägger till openPayCardView för knapp kopplad från bekräftelsesidan//
    @FXML
    public void openPayCardView (ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(MarsTravelApplication.class.getResource("PayCardView.fxml"));
    Parent cartParent = loader.load();
    Scene chosenScene = new Scene(cartParent);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setTitle("PayCard");
    window.setScene(chosenScene);
    window.show();
}
    @FXML
    public void addToCartTillFrån(){
        ShoppingCart cart = new ShoppingCart();
        SqlQuery sql = new SqlQuery();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
    if(rbtn_Till.isSelected()) {
        cart.addItem("Till");
    }
    if (rbtn_Från.isSelected()) {
        cart.addItem("Från");
        }
    ArrayList<String> cartList = cart.loadCart();
    sql.insertBooking(cartList);

        alert.setTitle("Informationer");
        alert.setHeaderText("Du har bekräftat!");
        alert.showAndWait();
    }
}

