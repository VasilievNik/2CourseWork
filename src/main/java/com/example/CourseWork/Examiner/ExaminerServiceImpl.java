package com.example.CourseWork.Examiner;

import com.example.CourseWork.Exceptions.OutOfBoundsException;
import com.example.CourseWork.Questions.Question;
import com.example.CourseWork.Questions.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int number) {
        Collection<Question> questionList = questionService.getList();
        if(number> questionList.size() || number<=0){
            throw new OutOfBoundsException();
        }

        Set<Question> integerHashSet = new HashSet<>();

        while(integerHashSet.size()<number) {
            integerHashSet.add(questionService.getRandomQuestion());
        }
        return integerHashSet;
    }

}
