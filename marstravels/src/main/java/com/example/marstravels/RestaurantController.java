package com.example.marstravels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class RestaurantController {
    public Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private final ObservableList<String> budgetItems = FXCollections.observableArrayList("Budget 1", "Budget 2", "Budget 3");
    private final ObservableList<String> mediumItems = FXCollections.observableArrayList("Mellan 1", "Mellan 2", "Mellan 3");
    private final ObservableList<String> luxuryItems = FXCollections.observableArrayList("Lyx 1", "Lyx 2", "Lyx 3");

    @FXML
    private Button btn_cartBudget;

    @FXML
    private Button btn_cartMedium;

    @FXML
    private Button btn_cartLuxury;

    @FXML
    private Button btn_Event;

    @FXML
    private Button btn_Restaurant;

    @FXML
    private Button btn_Room;

    @FXML
    private Button btn_Hotel;

    @FXML
    private ChoiceBox<String> chcbx_budget;

    @FXML
    private ChoiceBox<String> chcbx_medium;

    @FXML
    private ChoiceBox<String> chcbx_luxury;

    @FXML
    private ImageView imgbtn_Cart;

    @FXML
    private ImageView imgbtn_LogIn;

    @FXML
    private ImageView imgbtn_Logo;

    @FXML
    private TitledPane pane_Budget;

    @FXML
    private TitledPane pane_Luxury;

    @FXML
    private TitledPane pane_Medium;

    @FXML
    private void initialize() {
        chcbx_budget.setValue("Välj matpaket");
        chcbx_budget.setItems(budgetItems);
        chcbx_medium.setValue("Välj matpaket");
        chcbx_medium.setItems(mediumItems);
        chcbx_luxury.setValue("Välj matpaket");
        chcbx_luxury.setItems(luxuryItems);
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

    @FXML
    public void addToCartBudget() {
        ShoppingCart cart = new ShoppingCart();
        if(chcbx_budget.getValue().equals("Välj matpaket")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error: Du måste välja matpaket");
            alert.setHeaderText("Error: Du måste välja matpaket.");
            alert.showAndWait();

        }
        else {
            cart.addItem("2;" + chcbx_budget.getValue());
            alert.setTitle("Vald");
            alert.setHeaderText(chcbx_budget.getValue() + " är vald");
            alert.showAndWait();
        }
    }
    @FXML
    public void addToCartMedium() {
        ShoppingCart cart = new ShoppingCart();
        if(chcbx_medium.getValue().equals("Välj matpaket")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error: Du måste välja matpaket");
            alert.setHeaderText("Error: Du måste välja matpaket.");
            alert.showAndWait();

        }
        else {
            cart.addItem("2;" + chcbx_medium.getValue());
            alert.setTitle("Vald");
            alert.setHeaderText(chcbx_medium.getValue() + " är vald");
            alert.showAndWait();
        }
    }
    @FXML
    public void addToCartLuxury() {
        ShoppingCart cart = new ShoppingCart();
        if(chcbx_luxury.getValue().equals("Välj matpaket")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error: Du måste välja matpaket");
            alert.setHeaderText("Error: Du måste välja matpaket.");
            alert.showAndWait();

        }
        else {
            cart.addItem("2;" + chcbx_luxury.getValue());
            alert.setTitle("Vald");
            alert.setHeaderText(chcbx_luxury.getValue() + " är vald");
            alert.showAndWait();
        }
    }
}
