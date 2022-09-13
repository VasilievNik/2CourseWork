package com.example.CourseWork;

import com.example.CourseWork.Questions.Question;
import com.example.CourseWork.Questions.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class QuestionTests {

	List<Question> expected = new ArrayList<Question>();

	Question question1 = new Question("a?", "no a");
	Question question2 = new Question("a or b?", "c");
	Question question3 = new Question("a-z?", "ь");

	@Mock
	QuestionService questionService = new QuestionService() {

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
	public void addTest(){
		assertEquals(expected, questionService);
	}

	@Test
	public void removeTest(){
		questionService.remove(question2);
		expected.remove(1);
		assertEquals(expected, questionService);
	}

	@Test
	public void findTest(){
		assertEquals(expected.get(0), questionService.find(question1));
	}

	@Test
	public void randomTest(){
		expected.remove(question2);
		expected.remove(question3);
		questionService.remove(question2);
		questionService.remove(question3);
		assertEquals(expected.get(0), questionService.getRandomQuestion());
	}

}