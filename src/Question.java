/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmee
 */

public class Question {
    private int numOfQuestion;
    private String question;
    private String[] alternativs;
    private String rigtAlternative;
    

    public int getNumOfQuestion() {
        return numOfQuestion;
    }

    public void display(){
        System.out.println("Question: " + this.question );
        System.out.println("\t1. " + this.alternativs[0] + "\t\t" + "3. " + this.alternativs[2] );
        System.out.println("\t2. " + this.alternativs[1] + "\t\t" + "4. " + this.alternativs[3]);


    }
    
   

    public Question() {}
    public Question(int numOfQuestion, String question, String[] alternativs, String rigntAlternative) {
        this.numOfQuestion = numOfQuestion;
        this.question = question;
        this.alternativs = alternativs;
        this.rigtAlternative = rigntAlternative;
    }

    // === Getters ===
    public String getQuestion() {
        return question;
    }

    public String[] getAlternativs() {
        return alternativs;
    }

    public String getRigtAlternative() {
        return rigtAlternative;
    }

    // === Setters ===

    public void setNumOfQuestion(int numOfQuestion) {
        this.numOfQuestion = numOfQuestion;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAlternativs(String[] alternativs) {
        this.alternativs = alternativs;
    }

    public void setRigtAlternative(String rigtAlternative) {
        this.rigtAlternative = rigtAlternative;
    }
 

}

