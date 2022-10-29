/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.IOException;
import java.lang.System.Logger;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ahmee
 */
public class MainFXMLController implements Initializable {

    @FXML
    private AnchorPane ffff;
    @FXML
    private Button btnAlter1;
    @FXML
    private Button btnAlter2;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnAlter3;
    @FXML
    private Button btnAlter4;
    @FXML
    private Label lblQuestion;
    @FXML
    private Label lblScore;
    
    public String correctAnswer;
    
    public static String correct;
    
    private Player plyer = new Player();
    
    private int score = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    

    @FXML
    private void btnAlter1Clicked(ActionEvent event) {

        boolean answer = this.plyer.checkAnswer(this.btnAlter1.getText());
        System.out.println(answer);
        correct = this.correctAnswer;
        if(answer == true){
            this.displayCorrectAnswer();
            this.updateScore();
        }
        else{
            this.displayWrongAnswer();
        }
        this.displayNewQuestion();
    }
    
    @FXML
    private void btnAlter4Clicked(ActionEvent event) {
        boolean answer = this.plyer.checkAnswer(this.btnAlter4.getText());
        System.out.println(answer);
        correct = this.correctAnswer;
        if(answer == true){
            this.displayCorrectAnswer();
            this.updateScore();
        }
        else{
            this.displayWrongAnswer();
        }
        
        this.displayNewQuestion();
    }

    @FXML
    private void btnAlter2Clicked(ActionEvent event) {
        boolean answer = this.plyer.checkAnswer(this.btnAlter2.getText());
        correct = this.correctAnswer;
        System.out.println(answer);
        if(answer == true){
            this.displayCorrectAnswer();
            this.updateScore();
        }
        else{
            this.displayWrongAnswer();
        }
        this.displayNewQuestion();
    }

    @FXML
    private void btnAlter3Clicked(ActionEvent event) {
        boolean answer = this.plyer.checkAnswer(this.btnAlter3.getText());
        correct = this.correctAnswer;
        System.out.println(answer);
        if(answer == true){
            this.displayCorrectAnswer();
            this.updateScore();
        }
        else{
            this.displayWrongAnswer();
        }
        
        this.displayNewQuestion();
    }
    
    @FXML
    private void btnStartClicked(ActionEvent event) {
        System.out.println("Clicked Start !");
        lblQuestion.setText("Hala Madrid");
        this.displayNewQuestion();
        
        this.btnAlter1.setDisable(false);
        this.btnAlter2.setDisable(false);
        this.btnAlter3.setDisable(false);
        this.btnAlter4.setDisable(false);
        
        
    }
    
    private void updateScore(){
        this.score += 100;
        this.lblScore.setText(Integer.toString(this.score) );
    }
    
    private void displayWrongAnswer(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Wrong.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Wrong");
            stage.setScene(scene);
            
            
            
            stage.show();
        }catch(Exception e){
            System.out.println("ERRRRROR \n " );
            System.out.println(e );

        }
        
    }
    
    private void displayCorrectAnswer(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Correct.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Correct");
            stage.setScene(scene);
            stage.show();
            
            
        }catch(Exception e){
            System.out.println("ERRRRROR \n " );
            System.out.println(e );

        }


    }
    
    private void displayNewQuestion(){
        System.out.println("Inside displayQuestion !");
        String question =  this.plyer.getnewQuestion();
        System.out.println("Question = " + question);
        while(question == null){
            question =  this.plyer.getnewQuestion();
        }
        this.lblQuestion.setText(question);
        
        Question current = this.plyer.currentQuestion;
        this.correctAnswer = this.plyer.currentQuestion.getRigtAlternative();
        
        String [] alter = current.getAlternativs();
        
        this.btnAlter1.setText(alter[0]);
        this.btnAlter2.setText(alter[1]);
        this.btnAlter3.setText(alter[2]);
        this.btnAlter4.setText(alter[3]);
    }
}
