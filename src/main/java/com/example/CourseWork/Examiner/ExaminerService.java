package com.example.CourseWork.Examiner;

import com.example.CourseWork.Questions.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int number);

}
