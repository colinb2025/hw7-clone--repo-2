package edu.virginia.cs.hwseven;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloController {
    @FXML
    TextField createpassword1;

    @FXML
    TextField createpassword2;

    @FXML
    TextField loginemail;

    @FXML
    TextField loginpassword;

    @FXML
    Label loginError;

    @FXML
    Label createAccountError;

    @FXML
    TextField courseReview;

    @FXML
    TextField courseRating;

    @FXML
    private void switchTocreateAccount(ActionEvent event) throws IOException {
        Parent newScene = FXMLLoader.load(getClass().getResource("createAccount.fxml"));
        Scene scene = new Scene(newScene, 560, 800);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void switchTologin(ActionEvent event) throws IOException {
        Parent newScene = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(newScene, 560, 800);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void Login(ActionEvent event) throws IOException {
        //if username and password are correct and in database
        Parent newScene = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Scene scene = new Scene(newScene, 560, 800);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();



        //if username doesnt exist
        loginemail.setStyle("-fx-font-size: 20px; -fx-background-radius: 10px; -fx-background-color: white; -fx-border-color: red; -fx-border-radius: 10px;");
        loginpassword.setStyle("-fx-font-size: 20px; -fx-background-radius: 10px; -fx-background-color: white; -fx-border-color: red; -fx-border-radius: 10px;");
        loginError.setText("The username doesn't exist, please create a new account");
        loginError.setStyle("-fx-text-fill: red");

        Timeline loginErrorNoUsername = new Timeline(new KeyFrame(Duration.seconds(3), disappear -> {
            loginemail.setStyle("-fx-font-size: 20px; -fx-background-radius: 10px; -fx-background-color: white; -fx-border-color: grey; -fx-border-radius: 10px;");
            loginpassword.setStyle("-fx-font-size: 20px; -fx-background-radius: 10px; -fx-background-color: white; -fx-border-color: grey; -fx-border-radius: 10px;");
            loginError.setStyle("-fx-text-fill: transparent;");
        }));
        loginErrorNoUsername.play();

        loginemail.clear();
        loginemail.requestFocus();

        loginpassword.clear();



        //if username and password aren't right
        loginemail.setStyle("-fx-font-size: 20px; -fx-background-radius: 10px; -fx-background-color: white; -fx-border-color: red; -fx-border-radius: 10px;");
        loginpassword.setStyle("-fx-font-size: 20px; -fx-background-radius: 10px; -fx-background-color: white; -fx-border-color: red; -fx-border-radius: 10px;");
        loginError.setText("The username and password don't match, try again");
        loginError.setStyle("-fx-font-size: 12px; -fx-text-fill: red; -fx-font-family: Arial;");

        Timeline loginErrorDontMatch = new Timeline(new KeyFrame(Duration.seconds(3), disappear -> {
            loginemail.setStyle("-fx-font-size: 20px; -fx-background-radius: 10px; -fx-background-color: white; -fx-border-color: grey; -fx-border-radius: 10px;");
            loginpassword.setStyle("-fx-font-size: 20px; -fx-background-radius: 10px; -fx-background-color: white; -fx-border-color: grey; -fx-border-radius: 10px;");
            loginError.setStyle("-fx-font-size: 12px; -fx-text-fill: transparent; -fx-font-family: Arial;");
        }));
        loginErrorDontMatch.play();

        loginemail.clear();
        loginemail.requestFocus();

        loginpassword.clear();
    }

    @FXML
    private void createAccount(ActionEvent event) throws IOException {
        //if email is in database


        //if passwords aren't the same
        if (createpassword1.getText() != createpassword2.getText()) {
            createpassword1.setStyle("-fx-font-size: 20px; -fx-background-radius: 10px; -fx-background-color: white; -fx-border-color: red; -fx-border-radius: 10px;");
            createpassword2.setStyle("-fx-font-size: 20px; -fx-background-radius: 10px; -fx-background-color: white; -fx-border-color: red; -fx-border-radius: 10px;");
            createAccountError.setText("The passwords don't match, try again");
            createAccountError.setStyle("-fx-font-size: 12px; -fx-text-fill: red; -fx-font-family: Arial;");

            Timeline createErrorPasswordsDontMatch = new Timeline(new KeyFrame(Duration.seconds(3), disappear -> {
                createpassword1.setStyle("-fx-font-size: 20px; -fx-background-radius: 10px; -fx-background-color: white; -fx-border-color: grey; -fx-border-radius: 10px;");
                createpassword2.setStyle("-fx-font-size: 20px; -fx-background-radius: 10px; -fx-background-color: white; -fx-border-color: grey; -fx-border-radius: 10px;");
                createAccountError.setStyle("-fx-font-size: 12px; -fx-text-fill: transparent; -fx-font-family: Arial;");
            }));
            createErrorPasswordsDontMatch.play();

            createpassword1.clear();
            createpassword2.requestFocus();

            createpassword2.clear();
        }

        //else
        //add log in and go to main menu
    }

    @FXML
    private void goToleaveReview(ActionEvent event) throws IOException {
        Parent newScene = FXMLLoader.load(getClass().getResource("leaveReview.fxml"));
        Scene scene = new Scene(newScene, 560, 800);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void submitReview(ActionEvent event) throws IOException {
//        System.out.println(courseReview.getText().getClass());
//        if (courseRating.getText() != "1" && courseRating.getText() != "2" && courseRating.getText() != "3" && courseRating.getText() != "4" && courseRating.getText() != "5") {
//            System.out.println("this isn't a valid rating");
//        }
        //if statement to make sure that our courseRating is between 1 and 5


        //if student has already submitted a review


        //for adding to database
        System.out.println(courseReview.getText());
        System.out.println(courseRating.getText());
    }

    @FXML
    private void goToviewReviews(ActionEvent event) throws IOException {
        Parent newScene = FXMLLoader.load(getClass().getResource("viewReviews.fxml"));
        Scene scene = new Scene(newScene, 560, 800);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

        //load all current reviews
    }
}