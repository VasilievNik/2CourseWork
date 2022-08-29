package com.example.CourseWork.Examiner;

import com.example.CourseWork.Questions.Question;
import com.example.CourseWork.Questions.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    private static ArrayList<Question> questionList;
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        for(int i=1; i<=amount; i++){
            Question question1 = questionService.getRandomQuestion();
            questionList.add(question1);
        }
        return questionList;
    }

}
