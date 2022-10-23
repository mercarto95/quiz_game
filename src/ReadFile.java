import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    static public List<Question> questionList = new ArrayList<>();
    static private List<String> fileContent = new ArrayList<>();

    public static void printAllQuestions(){
        for (Question i : questionList){
            i.display();
        }
    }

    public static void extractObjects(){
        int counter = 0;
        for (String i : fileContent){
            counter ++;
            String [] tmpArray = i.split(",");
            Question newobj = new Question();
            if(tmpArray.length >= 6) {
                newobj.setQuestion(tmpArray[0]);
                String[] alternatives = {tmpArray[1], tmpArray[2], tmpArray[3], tmpArray[4]};
                newobj.setAlternativs(alternatives);
                newobj.setRigtAlternative(tmpArray[5]);
            }
            questionList.add(newobj);
        }

    }
    public static  void read(){
        try{
            File myFile = new File("/home/merengues/git/javaGui/competition/src/data/questions.csv");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                fileContent.add(data);
            }
            extractObjects();

        }
        catch(FileNotFoundException error){
            System.out.println("Can not open the file!\n");
            error.printStackTrace();
        }
    }

}
