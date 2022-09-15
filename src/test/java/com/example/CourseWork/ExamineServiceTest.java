package com.example.CourseWork;

import com.example.CourseWork.Examiner.ExaminerService;
import com.example.CourseWork.Examiner.ExaminerServiceImpl;
import com.example.CourseWork.Exceptions.OutOfBoundsException;
import com.example.CourseWork.Questions.Question;
import com.example.CourseWork.Questions.QuestionService;
import com.example.CourseWork.Questions.QuestionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamineServiceTest {

    private final QuestionService questionService = new QuestionServiceImpl();

    @InjectMocks
    private ExaminerService examinerService = new ExaminerServiceImpl(questionService);

    @Test
    public void negativeGetQuestionsTest(){
        assertThatExceptionOfType(OutOfBoundsException.class)
                .isThrownBy(()->examinerService.getQuestions(1));

        assertThatExceptionOfType(OutOfBoundsException.class)
                .isThrownBy(()->examinerService.getQuestions(-1));
    }

    @Test
    public void positiveGetQuestionsTest(){
        Question question1 = new Question("a?", "no a");
        Question question2 = new Question("a or b?", "c");
        Question question3 = new Question("a-z?", "ь");
        questionService.add(question1);
        questionService.add(question2);
        questionService.add(question3);
        assertThat(examinerService.getQuestions(3).contains(question1));
        assertThat(examinerService.getQuestions(3).contains(question2));
        assertThat(examinerService.getQuestions(3).contains(question2));
    }

}