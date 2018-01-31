import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class QuestionList {
    private ArrayList<Question> list;
    private int counter;

    public QuestionList(){
        this.list = new ArrayList<Question>();
        this.counter = 0;
    }

    public ArrayList<Question> getList() { //returns list
        return list;
    }

    public void addQuestion(Question q){ //adds question to list
        this.list.add(q);
    }

    public Question nextQuestion(){ //returns next question;
        try {
            return this.list.get(counter);
        }catch(java.lang.IndexOutOfBoundsException e){
            return null;
        }

    }

    public void incr(){ //returns next question;
        this.counter++;
    }
    public void resetCounter(){
        this.counter = 0;
    }

    public String toFile(){
        String listAsString = "";
        for(int i = 0; i < this.list.size(); i++){
            if(i != (this.list.size() - 1)) listAsString += this.list.get(i).toList() + "\n";
            else listAsString += this.list.get(i).toList();
        }
        return listAsString;
    }

    public void write(){
        FileWriter fw = null;
        try{
            fw = new FileWriter("src/Database.txt");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        PrintWriter pw = new PrintWriter(fw);

        pw.println(this.toFile());
        pw.close();
    }

}
