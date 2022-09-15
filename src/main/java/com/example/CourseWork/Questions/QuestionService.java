package com.example.CourseWork.Questions;

import java.util.Collection;

public interface QuestionService{

    Question add(Question question);

    Question remove(Question question);

    Question find(Question question);

    Question getRandomQuestion();

    Collection<Question> getList();
}

