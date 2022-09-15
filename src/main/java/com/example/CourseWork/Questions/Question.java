package com.example.CourseWork.Questions;

import java.util.Objects;

public class Question {
    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String toString(){
        return "Вопрос: "+this.question+" Ответ: "+this.answer;
    }

    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Question question1 = (Question) other;

        return question.equals(question1.question);
    }

    public int hashCode() {
        return Objects.hash(question);
    }

}