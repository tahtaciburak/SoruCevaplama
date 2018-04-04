package com.btahtaci.sorucevaplama;

import java.io.Serializable;

/**
 * Created by buraktahtaci on 4.04.2018.
 */

public class Question implements Serializable {

    private int id;
    private static int count = 0;
    private String questionText;
    private String category;
    private int correctAnswer;
    private String a;
    private String b;
    private String c;
    private String d;
    private int status; // 0 -> NULL , 1 -> CORRECT, 2 -> WRONG

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public Question(String questionText,String category,int correctAnswer,String a, String b, String c, String d,int status){
        id = ++count;
        this.questionText = questionText;
        this.category = category;
        this.correctAnswer = correctAnswer;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.status = status;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText(){
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String[] getAllAnswers(){
        String[] answers = new String[4];
        answers[0] = this.a;
        answers[1] = this.b;
        answers[2] = this.c;
        answers[3] = this.d;

        return answers;
    }

}
