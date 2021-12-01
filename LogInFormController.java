


import java.io.IOException;

import java.util.Objects;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;


import javax.swing.JOptionPane;


public class LogInFormController  {


    @FXML
    private AnchorPane rootPane;


    @FXML
    private TextField txt_login;

    @FXML
    private TextField txt_password;

    @FXML
  private Button btnSignIn;







    public LogInFormController() {

    }



    public void Login(ActionEvent event) throws IOException {



      User user= Client.network.searchLogin("login", txt_login.getText().trim(), txt_password.getText().trim());

        if (!user.equals(new User(0, "", "",""))) {

       if(Objects.equals(user.getStatus(), "admin"))
       {    JOptionPane.showMessageDialog(null, "Вы успешно зашли как Админ!");
           AnchorPane pane=  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Kursach.fxml")));

           rootPane.getChildren().setAll(pane);}

       else {
           JOptionPane.showMessageDialog(null, "Вы успешно зашли как Пользователь!");
           AnchorPane pane=  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("User.fxml")));

           rootPane.getChildren().setAll(pane);

       }


        } else {
            JOptionPane.showMessageDialog(null, "Такой пользователь не найден! Повторите ввод!");

        }



    }



}