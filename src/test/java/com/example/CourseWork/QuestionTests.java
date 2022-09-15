package com.example.CourseWork;

import com.example.CourseWork.Exceptions.QuestionAlreadyExistException;
import com.example.CourseWork.Exceptions.QuestionNotFoundException;
import com.example.CourseWork.Questions.Question;
import com.example.CourseWork.Questions.QuestionService;
import com.example.CourseWork.Questions.QuestionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
public class QuestionTests {

	Question question1 = new Question("a?", "no a");
	Question question2 = new Question("a or b?", "c");
	Question question3 = new Question("a-z?", "ь");


	private final QuestionService questionService = new QuestionServiceImpl();

	@BeforeEach
	public void setUp(){
		questionService.getList().forEach(questionService::remove);
	}

	@Test
	public void addTest(){
		questionService.add(question1);
		assertThat(questionService.getList().contains(question1));

		assertThatExceptionOfType(QuestionAlreadyExistException.class)
				.isThrownBy(()->questionService.add(question1));
	}

	@Test
	public void removeTest(){
		questionService.add(question1);
		questionService.remove(question1);
		assertThat(questionService.getList().isEmpty());

		assertThatExceptionOfType(QuestionNotFoundException.class)
				.isThrownBy(()->questionService.remove(question1));
	}

	@Test
	public void findTest(){
		questionService.add(question1);
		assertThat(questionService.getList().contains(questionService.find(question1)));
	}

	@Test
	public void randomTest(){
		questionService.add(question1);
		questionService.add(question2);
		questionService.add(question3);
		assertThat(questionService.getList().contains(questionService.getRandomQuestion()));
	}

}