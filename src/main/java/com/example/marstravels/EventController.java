package com.example.marstravels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class EventController {

    public Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private final ObservableList<String> concertItems = FXCollections.observableArrayList("Mars Rockers", "Alien Invaders", "Haru Crew");
    private final ObservableList<String> movieItems = FXCollections.observableArrayList("Men in Black", "Alien", "Alien 2", "Emrik the Alien", "Area 51", "E.T.");
    private final ObservableList<String> theaterItems = FXCollections.observableArrayList("Phantom of the Minhui", "Engla the Alien", "Axel the Spacehuman");
    private final ObservableList<Integer> amountOfPeople = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6);

    @FXML
    private ChoiceBox<String> chcbx_Concert;

    @FXML
    private ChoiceBox<String> chcbx_Movie;

    @FXML
    private ChoiceBox<String> chcbx_Theater;

    @FXML
    private ChoiceBox<Integer> chcbox_ConcertAmount;

    @FXML
    private ChoiceBox<Integer> chcbox_MovieAmount;

    @FXML
    private ChoiceBox<Integer> chcbox_PoolAmount;

    @FXML
    private ChoiceBox<Integer> chcbox_TheaterAmount;

    @FXML
    private Button btn_BookConcert; // gjorde denna för säkerhetsskull

    @FXML
    private Button btn_BookMovie;

    @FXML
    private Button btn_BookPool;

    @FXML
    private Button btn_BookTheater;

    @FXML
    private Button btn_Event;

    @FXML
    private Button btn_Room;

    @FXML
    private Button btn_Restaurant;

    @FXML
    private Button btn_Hotel;

    @FXML
    private ImageView imgbtn_Cart;

    @FXML
    private ImageView imgbtn_LogIn;

    @FXML
    private ImageView imgbtn_Logo;

    /** added by haru, testar image btn */
    @FXML
    private ImageView imgbtn_CartInBtn;


    @FXML
    private void initialize() {
        chcbx_Concert.setValue("Välj konsert");
        chcbx_Concert.setItems(concertItems);
        chcbx_Movie.setValue("Välj film");
        chcbx_Movie.setItems(movieItems);
        chcbx_Theater.setValue("Välj föreställning");
        chcbx_Theater.setItems(theaterItems);
        chcbox_PoolAmount.setValue(1);
        chcbox_ConcertAmount.setValue(1);
        chcbox_MovieAmount.setValue(1);
        chcbox_TheaterAmount.setValue(1);
        chcbox_TheaterAmount.setItems(amountOfPeople);
        chcbox_PoolAmount.setItems(amountOfPeople);
        chcbox_MovieAmount.setItems(amountOfPeople);
        chcbox_ConcertAmount.setItems(amountOfPeople);
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

    @FXML
    public void addBadhus() {
        ShoppingCart cart = new ShoppingCart();
        int amount = 0;
        for (int i = 0; i < chcbox_PoolAmount.getValue(); i++){
            int count = i + 1;
            cart.addItem("3." + i + ";" + "Badhus");
            cart.addItem("3i;" + count);
            amount = count;
        }
        alert.setTitle("Vald");
        alert.setHeaderText(amount + " antal är valda");
        alert.showAndWait();
    }

    @FXML
    public void addBio() {
        ShoppingCart cart = new ShoppingCart();
        int amount = 0;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (chcbx_Movie.getValue().equals("Välj film")) {
            alert.setTitle("Error: Välj film");
            alert.setHeaderText("Error: Du måste välja film.");
            alert.showAndWait();
        } else {
            for (int i = 0; i < chcbox_MovieAmount.getValue(); i++) {
                int count = i + 1;
                cart.addItem("4." + i + ";" + chcbx_Movie.getValue());
                cart.addItem("4i;" + count);
                amount = count;
            }
            alert.setTitle("Vald");
            alert.setHeaderText(amount + " antal är valda");
            alert.showAndWait();
        }
    }

    @FXML
    public void addTheater() {
        ShoppingCart cart = new ShoppingCart();
        int amount = 0;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (chcbx_Theater.getValue().equals("Välj föreställning")) {
            alert.setTitle("Error: Välj föreställning & antal");
            alert.setHeaderText("Error: Du måste välja föreställning & antal.");
            alert.showAndWait();
        } else {
            for (int i = 0; i < chcbox_TheaterAmount.getValue(); i++) {
                int count = i + 1;
                cart.addItem("5." + i + ";" + chcbx_Theater.getValue());
                cart.addItem("5i;" + count);
                amount = count;
            }
            alert.setTitle("Vald");
            alert.setHeaderText(amount + " antal är valda");
            alert.showAndWait();
        }
    }

    @FXML
    public void addConcert() {
        FileHandler cartAdder = new FileHandler();
        ShoppingCart cart = new ShoppingCart();
        int amount = 0;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (chcbx_Concert.getValue().equals("Välj konsert")) {
            alert.setTitle("Error: Välj konsert");
            alert.setHeaderText("Error: Du måste välja konsert.");
            alert.showAndWait();
        } else {
            for (int i = 0; i < chcbox_ConcertAmount.getValue(); i++) {
                int count = i + 1;
                cart.addItem("6." + i + ";" + chcbx_Concert.getValue());
                cart.addItem("6i;" + count);
                amount = count;

            }
            alert.setTitle("Vald");
            alert.setHeaderText(amount + " antal är valda");
            alert.showAndWait();
        }
    }
}
