package quiz.interfaces;

public  interface QUIZ {
    void start();
    void submitAnswer(int questionIndex, String answer);
    void showResults();
}