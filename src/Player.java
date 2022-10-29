
import java.util.Scanner;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmee
 */

public class Player {
    String username;
    int age;
    int score = 0;
    int questionsCursor = 0;
    Question currentQuestion = new Question();

    Scanner scanner = new Scanner(System.in);
    

    public String getName(){
        System.out.printf("Name? ");
        String name = scanner.nextLine();
        return name;
    }

    public void displayQuestion(){
        
    }

    public int getAnswer(){
        System.out.printf("\t-> Your Answer: ");
        int alter  = scanner.nextInt();
        return alter;
    }
    
    public boolean checkAnswer(String answer){
        String correctOne = this.currentQuestion.getRigtAlternative();
        if(correctOne.equals(answer)){    
            return true;
        }
        System.out.printf("Wrong Answer");
        
        return false;
    }

    public boolean getResult(Question question, int answer){
        int correctChoice = 100;
        String correctAnswer = question.getRigtAlternative();
        String[] list = question.getAlternativs();
        String cr = question.getRigtAlternative();
        for(int i = 0; i < 4; i++){
            if(cr.equals(list[i])){
                correctChoice = i+1;
                break;
            }
        }
        if(correctChoice == answer){
            return true;
        }
        return false;
    }

    boolean initialize(){
        ReadFile.read();
        return true;
    }

    public String getnewQuestion(){
        // to develop: make chooae questions randomly
        Question questionToReturn = ReadFile.questionList.get(questionsCursor);
        this.questionsCursor ++;
        
        if(this.questionsCursor >= ReadFile.questionList.size()){
            questionsCursor = 0;
        }
        
        this.currentQuestion = questionToReturn;
        
        return questionToReturn.getQuestion();
    }
    
    public Question getQuestion(){
        return this.currentQuestion;
    }


    public int gameModirator(){
        this.getName();
        
        while (this.questionsCursor < ReadFile.questionList.size()){
            ReadFile.questionList.get(questionsCursor).display();
            int answer = getAnswer();
            boolean result = getResult(ReadFile.questionList.get(questionsCursor), answer);
            this.questionsCursor ++;

            if(result == true){
                this.score += 1000;
                System.out.println("===== Correct Answer!!!. -> Current amound : " + this.score + "  =====");

            }
            else {
                System.out.println(" : - ( Wrong wrong wrong!!!\n");
            }

        }


        return 0;
    }
}
