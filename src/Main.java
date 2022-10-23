public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ReadFile.read();

        Player playerObj = new Player();
        playerObj.gameModirator();

        System.out.println("\n\t\t You Win " + playerObj.score);

        //ReadFile.printAllQuestions();
    }




}









