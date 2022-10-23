import java.util.Scanner;

public class Player {
    String username;
    int age;
    int score = 0;
    int questionsCursor = 0;

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

