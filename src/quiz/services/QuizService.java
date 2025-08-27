package quiz.services;

import quiz.interfaces.QUIZ;
import quiz.models.Question;

import java.util.Scanner;
import java.util.SplittableRandom;

public class QuizService implements QUIZ{
    private Question[] questions;
    private String[] userAnswers;
    private  int score=0;

    public QuizService(Question[] questions)
    {
        this.questions=questions;
        this.userAnswers= new String[questions.length] ;
    }

    @Override
    public void start()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Online Quiz!");
        for( int i=0; i<questions.length;i++)
        {
            //prints question statements
            System.out.println("\nQ" + (i+1) + ":" + questions[i].getQuestionText());
            String[] options= questions[i].getOptions();
            //prints options
            for(int j=0; j< options.length;j++)
            {
                System.out.println((j+1) + "." + options[j]);
            }

            System.out.println("Enter your answer (1-"+ options.length + "):");
            String input = sc.nextLine();
            int answerIndex;
            try{
                answerIndex= Integer.parseInt(input);
                if( answerIndex < 1 || answerIndex> options.length)
                {
                    System.out.println("Invalid Option Answer recorded as blank.");
                    userAnswers[i] = "";
                }
                else {
                    userAnswers[i] = options[answerIndex-1];
                }
            }
            //trying to input other than number
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input, answer recorded as blank.");
                userAnswers[i] = "";
            }
        }
    }

    @Override
    public void submitAnswer(int questionIndex, String answer) {
        if(questionIndex>=0 && questionIndex< userAnswers.length)
        {
            userAnswers[questionIndex]= answer;
        }
    }

    @Override
    public void showResults() {
        score =0;
        for(int i=0 ; i< questions.length ;i++)
        {
            if( questions[i].getCorrectAnswer().equalsIgnoreCase((userAnswers[i])))
            {
                score++;
            }
        }
        System.out.println("\n Quiz completed!");
        System.out.println("your Score: "+ score + " out of "+ questions.length);

    }
}