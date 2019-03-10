package edu.msu.cardquiz;

public class Questions {
    //string array of questions
    public String mQuestions [] = {
            "Who was the first president of USA?",
            "Who was the 11th president of USA?",
            "Who is the current president of USA?",
            "Who was the 44th president of USA?",
            "Who was the 8th president of USA?" };
    //string array of possible choices presented to user
    private String mChoices [][] = {
            {"Polk", "Washington", "Trump","Obama"},
            {"Polk", "Washington", "Trump","Obama"},
            {"Polk", "Washington", "Trump","Obama"},
            {"Polk", "Washington", "Trump","Obama"},
            {"Buren", "Washington", "Trump","Obama"},
    };
    //string of correct answer in order of mQuestions
    private String mCorrectAnswers[] = {"Washington", "Polk", "Trump", "Obama", "Buren"};
    //gives order of questions and returns the choice
    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }
    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return choice;
    }
    public String getChoice2(int a) {
        String choice = mChoices[a][1];
        return choice;
    }
    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return choice;
    }
    public String getChoice4(int a) {
        String choice= mChoices[a][3];
        return choice;
    }
    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }}
