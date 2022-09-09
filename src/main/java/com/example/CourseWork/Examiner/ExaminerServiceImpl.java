package com.example.CourseWork.Examiner;

import com.example.CourseWork.Exceptions.OutOfBoundsException;
import com.example.CourseWork.Questions.Question;
import com.example.CourseWork.Questions.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    private static ArrayList<Question> questionList;
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(amount>questionList.size()){
            throw new OutOfBoundsException();
        }

        HashSet<Question> integerHashSet = new HashSet<>();

        for(int i=1; i<=amount; i++){
            Question question1 = questionService.getRandomQuestion();

            if (integerHashSet.contains(question1)){
                i--;
            }
            else{
                integerHashSet.add(question1);
                questionList.add(question1);
            }
        }
        return questionList;
    }

}
