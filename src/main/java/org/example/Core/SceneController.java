package org.example.Core;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.security.auth.login.LoginException;

public class SceneController {
    @FXML
    public TextField apiKey;
    @FXML
    public TextField botToken;
    @FXML
    public Button runButton;
    @FXML
    public Button stopButton;


    public void onRun(ActionEvent actionEvent) throws LoginException {
        JDA jda = new JDA(getBotToken(),getApiKey());
        jda.jdaBuilder();
    }

    public void onStop(ActionEvent actionEvent) {
        System.exit(1);
    }

    public String getBotToken(){
        return botToken.getText();
    }

    public String getApiKey(){
        return apiKey.getText();
    }
}
