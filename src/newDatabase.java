import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class newDatabase {
    private static newDatabase ourInstance = new newDatabase();

    public static newDatabase getInstance() {
        return ourInstance;
    }

    private QuestionList universalList = new QuestionList();
    public QuestionList getUniversalList(){
        return this.universalList;
    }
    public void setUniversalList(QuestionList ql){
        this.universalList = ql;
    }

    private newDatabase() {
        this.universalList = read(getScanner());
    }

    public void updateList(){
        this.universalList = read(getScanner());
    }

    static void print(){
        System.out.println("fhhfhf");
    }

    public QuestionList read(Scanner sc){
        int readCounter = 0;
        QuestionList list = new QuestionList(); //initializes list to be filled by reading a file
        while(sc.hasNextLine()){
            String nextLine = sc.nextLine(); //gets the whole next line
            String[] next = nextLine.split(","); //splits the line based on commas
            readCounter++;
            ArrayList answers = null;


            try {
                //puts possible answers (PA's) in an arraylist
                answers = new ArrayList();
                answers.add(next[2]);
                answers.add(next[3]);
                answers.add(next[4]);
                answers.add(next[5]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("comma error: " + nextLine);
            }

            Question tempQ = new Question(next[0], next[1], answers); //initializes the question
            list.addQuestion(tempQ); //adds read question to questionList
        }
        System.out.println(readCounter + " questions loaded!\n");
        return list;
    }

    public static Scanner getScanner(){
        File db = new File("src/Database.txt");
        String fileName = db.getPath();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        Scanner sc = null;

        try {
            fis = new FileInputStream(fileName);
            isr = new InputStreamReader(fis);
            sc = new Scanner(isr);
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return sc;
    }
}

