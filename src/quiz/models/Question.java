package quiz.models;

public class Question {
    private String questionText;
    private String [] options;
    private String correctAnswer;
    //Constructor to add ques statement with option and answer
    public  Question(String questionText,String[] options, String correctAnswer)
    {
        this.questionText=questionText;
        this.options=options;
        this.correctAnswer=correctAnswer;
    }
    public String getQuestionText()
    {
        return questionText;
    }
    public String[] getOptions()
    {
        return options;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
