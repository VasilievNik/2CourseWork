package com.example.CourseWork;

import com.example.CourseWork.Examiner.ExaminerServiceImpl;
import com.example.CourseWork.Exceptions.OutOfBoundsException;
import com.example.CourseWork.Questions.Question;
import com.example.CourseWork.Questions.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamineServiceTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void negativeGetQuestionsTest(){
        when(questionService.getList()).thenReturn(Collections.emptyList());
        assertThatExceptionOfType(OutOfBoundsException.class)
                .isThrownBy(()->examinerService.getQuestions(1));

        assertThatExceptionOfType(OutOfBoundsException.class)
                .isThrownBy(()->examinerService.getQuestions(-1));
    }

    @Test
    public void positiveGetQuestionsTest(){
        Question question1 = new Question("1", "-1");
        Question question2 = new Question("2", "-2");
        Question question3 = new Question("3", "-3");
        Question question4 = new Question("4", "-4");

        Set<Question> allQuestions = Set.of(question1, question2, question3, question4);

        when(questionService.getList()).thenReturn(allQuestions);
        when(questionService.getRandomQuestion()).thenReturn(question3, question2, question1, question4);

        assertThat(examinerService.getQuestions(4)).containsExactlyInAnyOrder(question3,question2,question1,question4);
    }

}