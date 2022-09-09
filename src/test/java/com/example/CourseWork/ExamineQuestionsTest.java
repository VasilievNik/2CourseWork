package com.example.CourseWork;

import com.example.CourseWork.Examiner.ExaminerService;
import com.example.CourseWork.Questions.Question;
import com.example.CourseWork.Questions.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

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
    ExaminerService examinerService = new ExaminerService() {
        @Override
        public Collection<Question> getQuestions(int amount) {
            return null;
        }
    };

    @Mock
    QuestionService questionService = new QuestionService() {
        @Override
        public Question add(String question, String answer) {
            return null;
        }

        @Override
        public Question add(Question question) {
            return null;
        }

        @Override
        public Question remove(Question question) {
            return null;
        }

        @Override
        public Question find(Question question) {
            return null;
        }

        @Override
        public Question getRandomQuestion() {
            return null;
        }
    };

    @BeforeEach
    public void setUp(){
        QuestionService questionService = this.questionService;
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