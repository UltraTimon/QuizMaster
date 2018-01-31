import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        newDatabase newDB = newDatabase.getInstance();
        Scanner ui = new Scanner(System.in);

        while(true){
            System.out.println("Welcome to quizMaster! Please choose:");
            System.out.println("1: practise questions");
            System.out.println("2: add questions");
            System.out.println("3: quit");

            int userChoice = 0;
            try {
                userChoice = ui.nextInt();
            }catch(InputMismatchException e){

            }

            if(userChoice == 1){
                System.out.println("Here are the questions:");
                Quiz.start();
            }
            if(userChoice == 2){
                    System.out.println("Fill in the fields.");
                    addQuestionToList(ui, newDB);
                    newDB.getUniversalList().write();
                    newDB.updateList();
            }
            if(userChoice == 3){
                break;
            }
        }
    }
    public static void addQuestionToList(Scanner sc, newDatabase newDB){
        sc.nextLine();
        System.out.print("Q:");
        String questionText = sc.nextLine();
        System.out.println();

        System.out.print("CA:");
        String rightAnswer = sc.nextLine();
        System.out.println();

        System.out.print("PA1:");
        String a1 = sc.nextLine();
        System.out.println();

        System.out.print("PA2:");
        String a2 = sc.nextLine();
        System.out.println();

        System.out.print("PA3:");
        String a3 = sc.nextLine();
        System.out.println();

        System.out.print("PA4:");
        String a4 = sc.nextLine();
        System.out.println();

        ArrayList userAnswers = new ArrayList();
        userAnswers.add(a1);
        userAnswers.add(a2);
        userAnswers.add(a3);
        userAnswers.add(a4);

        Question tempQ = new Question(questionText, rightAnswer, userAnswers);
        newDB.getUniversalList().addQuestion(tempQ);
        System.out.println("done, question added: \n" + tempQ.toList());
    }
}
