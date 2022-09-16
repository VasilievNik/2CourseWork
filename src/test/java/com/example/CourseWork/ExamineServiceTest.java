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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

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
        Question question1 = new Question("a?", "no a");
        Question question2 = new Question("a or b?", "c");
        Question question3 = new Question("a-z?", "ь");

        Set<Question> allQuestions = Set.of(question1, question2, question3);

        when(questionService.getList()).thenReturn(allQuestions);
        when(questionService.getRandomQuestion()).thenReturn(question1, question2, question1, question3);

        assertThat(examinerService.getQuestions(3)).containsExactlyInAnyOrder(question1,question2,question1);
        assertThat(examinerService.getQuestions(3)).contains(question1);
    }

}