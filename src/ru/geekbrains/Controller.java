package ru.geekbrains;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    TextField msgField;

    @FXML
    TextArea mainTextArea;

    @FXML
    public void onPressEnter(ActionEvent actionEvent){
        sendEvent(actionEvent);
    }
    public void clickSendBtn(ActionEvent actionEvent) {
        sendEvent(actionEvent);
    }

    private void sendEvent(ActionEvent actionEvent) {
        if(msgField.getText().trim().isEmpty()){
            return;
        }
        mainTextArea.appendText("Вы: " + msgField.getText() + "\n");
        msgField.clear();
        msgField.requestFocus();
    }
}
