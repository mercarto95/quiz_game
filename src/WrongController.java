/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ahmee
 */
public class WrongController implements Initializable {
    
    public Button btnClose;
    public Label lblCorrectAnswer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    int i = 0;
    public void btnCloseClicked(ActionEvent event) throws InterruptedException {
        System.out.println("CLICKEDDDD");
        if(i == 0 ){
            System.out.println(MainFXMLController.correct);
            this.btnClose.setText("Close!");
            String correctAnswer = "The Correct Answer = " + MainFXMLController.correct;
            this.lblCorrectAnswer.setText(correctAnswer);
            i = 1;
            return;
        }
        if( i == 1){
            this.btnClose.setText("Show Correct Answer");
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
            i = 0;
        }
    }
    
    

    
}
