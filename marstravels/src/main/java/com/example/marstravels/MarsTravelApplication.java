package com.example.marstravels;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MarsTravelApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        ShoppingCart cart = new ShoppingCart();
        cart.clearCart(); //tömmer cart i början av programmet.
        FXMLLoader root = new FXMLLoader(MarsTravelApplication.class.getResource("RoomToMarsView.fxml"));
        Scene scene = new Scene(root.load(), 600, 400);
        primaryStage.setTitle("Book a Room to Mars");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {

        SqlQuery sql = new SqlQuery();

        launch();


       //List<String> sqlBooking = cart.createBooking();

        //sql.insertTestbokning( sqlBooking.get(0), sqlBooking.get(1), sqlBooking.get(2), sqlBooking.get(3));

    }

}