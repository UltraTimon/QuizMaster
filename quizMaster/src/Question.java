public class Question {
    private String questionText;
    private String[] answers = new String[4];
    private String rightAnswer;

    public Question(String questionText, String rightAnswer, String[] answers) {
        this.questionText = questionText;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    public String toList(){
        return this.questionText + "," + this.getRightAnswer() + "," + this.getAnswers()[0] + "," + this.getAnswers()[1] + "," + this.getAnswers()[2] + "," + this.getAnswers()[3];
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public String[] getAnswers() {
        return this.answers;
    }

    public String getRightAnswer(){
        return this.rightAnswer;
    }


}
