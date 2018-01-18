import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Quiz {

    public static void start(){
        newDatabase newDB = newDatabase.getInstance();

        QuestionList list = newDB.getUniversalList();
        Scanner sc = new Scanner(System.in);
        list.resetCounter();

        while(true){
            Question nextQuestion = list.nextQuestion();
            if(nextQuestion == null){
                break;
            }
            System.out.println(list.nextQuestion().getQuestionText()); //next question appears on screen
            for(int i = 0; i < nextQuestion.getAnswers().length; i++){
                System.out.println(i + 1 + " - " + nextQuestion.getAnswers()[i]);
            }
            int userChoice = sc.nextInt();
            if(check(userChoice, nextQuestion)){//answer gets checked
                list.incr(); //counter gets incremented so next question appears
            }else{
                System.out.println("WRONG! Try again later!");
            }

        }
        System.out.println("done");
    }
    public static boolean check(int userAnswer, Question q){
        if(q.getAnswers()[userAnswer - 1].equals(q.getRightAnswer())){
            return true;
        }
        else return false;
    }


}
