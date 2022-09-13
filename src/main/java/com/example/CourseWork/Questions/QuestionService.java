package com.example.CourseWork.Questions;

public interface QuestionService{

    Question add(Question question);

    Question remove(Question question);

    Question find(Question question);

    Question getRandomQuestion();
}

