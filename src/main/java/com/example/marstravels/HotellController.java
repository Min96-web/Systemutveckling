package com.example.marstravels;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class HotellController {

    public Alert alert = new Alert(Alert.AlertType.INFORMATION);
    public void popupAlert(String choice){
        alert.setTitle("Vald");
        alert.setHeaderText(choice + " är vald");
        alert.showAndWait();
    };

    final ToggleGroup group = new ToggleGroup();

    public void initialize() {
        rbtn_SinglePb.setToggleGroup(group);
        rbtn_DoublePb.setToggleGroup(group);
        rbtn_SingleDm.setToggleGroup(group);
        rbtn_DoubleDm.setToggleGroup(group);
        rbtn_LuxRc.setToggleGroup(group);
        rbtn_DoubleRoyalRc.setToggleGroup(group);
        rbtn_SuiteRc.setToggleGroup(group);


    }

    @FXML
    private Button btn_BookDm;

    @FXML
    private Button btn_BookLd;

    @FXML
    private Button btn_BookPb;

    @FXML
    private Button btn_BookRc;

    @FXML
    private Button btn_BookWd;

    @FXML
    private DatePicker datepick_BookDm;

    @FXML
    private DatePicker datepick_BookRc;

    @FXML
    private DatePicker datepick_BookWd;

    @FXML
    private DatePicker datepick_Pb;

    @FXML
    private DatePicker datepicker_BookLd;

    @FXML
    private RadioButton rbtn_DoubleDm;

    @FXML
    private RadioButton rbtn_DoublePb;

    @FXML
    private RadioButton rbtn_DoubleRoyalRc;

    @FXML
    private RadioButton rbtn_LuxRc;

    @FXML
    private RadioButton rbtn_SingleDm;

    @FXML
    private RadioButton rbtn_SinglePb;

    @FXML
    private RadioButton rbtn_SuiteRc;
    @FXML
    private Button btn_Event;

    @FXML
    private Button btn_Hotel;

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
    @FXML
    private void addToCartPL() {
        /* HARU: String date sätter jag som tom så man eventuellt kan jobba med den i framtiden..
        *  ta senare bort "" och kommentaren så får vi fram datum.
        * exempel på fx:id i fxml: datepicker_BookLd för lansdorp */
        String date = ""; //datepicker_BookLd.getValue().toString();

        ShoppingCart cart = new ShoppingCart();

                cart.addItem("9;" + "Polar Lansdorp;" + date);
                popupAlert("Polar Lansdorp");
        }
    @FXML
    private void addToCartPW () {
        String date = ""; //datepick_BookWd.getValue().toString();
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("9;" + "Polar Wielders;" + date);
        popupAlert("Polar Wielders");
    }

    @FXML
    private void addToCartHP () {
        String date = ""; //datepick_Pb.getValue().toString();
        ShoppingCart cart = new ShoppingCart();
        if (rbtn_SinglePb.isSelected()) {
            cart.addItem("9;" + "Hotel Phobos, enkelrum;");
            popupAlert("Hotel Phobos enkel");
        }
        if (rbtn_DoublePb.isSelected()) {
            cart.addItem("9;" + "Hotel Phobos, dubbelrum;");
            popupAlert("Hotel Phobos dubbel");
        }
    }

    @FXML
    private void addToCartHD () {
        ShoppingCart cart = new ShoppingCart();
        String date = ""; //datepick_BookDm.getValue().toString();
        if (rbtn_SingleDm.isSelected()) {
            cart.addItem("9;" + "Hotel Deimos, enkelrum;" + date);
            popupAlert("Hotel Deimos enkel");
        }
        if (rbtn_DoubleDm.isSelected()) {
            cart.addItem("9;" + "Hotel Deimos, dubbelrum;" + date);
            popupAlert("Hotel Deimos dubbel");
        }
    }

    @FXML
    private void addToCartRC () {
        ShoppingCart cart = new ShoppingCart();

        String date = ""; //datepick_BookRc.getValue().toString();
        if (rbtn_LuxRc.isSelected()) {
            cart.addItem("9;" + "Royal City, enkel lyx;" + date);
            popupAlert("Royal City enkel");
        }
        if (rbtn_SuiteRc.isSelected()) {
            cart.addItem("9;" + "Royal City, svit;" + date);
            popupAlert("Royal City Svit");
        }
        if (rbtn_DoubleRoyalRc.isSelected()) {
            cart.addItem("9;" + "Royal City, dubbel lyx;" + date);
            popupAlert("Royal City dubbel");
        }
    }

}