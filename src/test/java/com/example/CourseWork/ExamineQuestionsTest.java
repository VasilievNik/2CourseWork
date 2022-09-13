package com.example.CourseWork;

import com.example.CourseWork.Examiner.ExaminerService;
import com.example.CourseWork.Questions.Question;
import com.example.CourseWork.Questions.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ExamineQuestionsTest {

    List<Question> expected = new ArrayList<Question>();

    Question question1 = new Question("a?", "no a");
    Question question2 = new Question("a or b?", "c");
    Question question3 = new Question("a-z?", "ь");

    @Mock
    ExaminerService examinerService = null;


    @BeforeEach
    public void setUp(){
        QuestionService questionService = null;
        questionService.add(question1);
        questionService.add(question2);
        questionService.add(question3);

        expected.add(question1);
        expected.add(question2);
        expected.add(question3);
    }

    @Test
    public void getQuestionsTest(){
        List<Question> actual = (List<Question>) examinerService.getQuestions(3);
        assertEquals(expected, actual);
    }

}