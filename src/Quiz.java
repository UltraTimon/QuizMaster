import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Quiz {

    public static void start(){
        newDatabase newDB = newDatabase.getInstance();

        QuestionList list = newDB.getUniversalList();
        Scanner sc = new Scanner(System.in);
        list.resetCounter();

        //shuffling question list
        Collections.shuffle(list.getList());

        while(true){
            Question nextQuestion = list.nextQuestion();
            if(nextQuestion == null){
                break;
            }
            //shuffling answers of current question
            ArrayList currentAnswers = nextQuestion.getAnswers();
            Collections.shuffle(currentAnswers);

            //next question appears on screen
            System.out.println(list.nextQuestion().getQuestionText());
            for(int i = 0; i < currentAnswers.size(); i++){
                System.out.println(i + 1 + ") " + currentAnswers.get(i));
            }

            //getting user input
            int userChoice = -2;
            while(true){
                userChoice = 6;
                userChoice = getUserInput(sc);
                if(!(userChoice == -1)){
                    break;
                }
                System.out.println("it iss -1");
            }

            //checking user input
            if(check(userChoice, nextQuestion, currentAnswers)){//answer gets checked
                list.incr(); //counter gets incremented so next question appears
                System.out.println("CORRECT!");
                System.out.println("\n---------------------------------\n");
            }else{
                System.out.println("WRONG!");
                System.out.println("\n---------------------------------\n");
                list.incr();
            }

        }
        System.out.println("End of the quizz! ");
        System.out.println("\n---------------------------------\n");
    }
    public static boolean check(int userAnswer, Question q, ArrayList currentA){
        if(currentA.get(userAnswer - 1).equals(q.getRightAnswer())){
            return true;
        }
        else return false;
    }
    public static int getUserInput(Scanner sc){
        int userChoice = -1;
        try{
            //sc.nextLine();
            userChoice = sc.nextInt();
        }catch (InputMismatchException e){ //catching InputMismatchException

            System.out.println("Input was not a number. please try again:");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            return -1;
        }
        if(userChoice < 1 || userChoice > 4){ //checking for indexOutOfBoundsException
            System.out.println("Input was not 1, 2, 3 or 4. please try again:");
            return -1;
        }
        return userChoice;
    }

}
