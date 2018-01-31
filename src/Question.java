import java.util.ArrayList;
import java.util.Collections;

public class Question {
    private String questionText;
    private ArrayList answers = new ArrayList();
    private String rightAnswer;

    public Question(String questionText, String rightAnswer, ArrayList answers) {
        this.questionText = questionText;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    public String toList(){
        return this.questionText + "," + this.getRightAnswer() + "," + this.getAnswers().get(0) + "," + this.getAnswers().get(1) + "," + this.getAnswers().get(2) + "," + this.getAnswers().get(3);
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public ArrayList getAnswers() {
        return this.answers;
    }

    public String getRightAnswer(){
        return this.rightAnswer;
    }


}
