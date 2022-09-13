package com.example.CourseWork.Questions;

import com.example.CourseWork.Exceptions.QuestionAlreadyExistException;
import com.example.CourseWork.Exceptions.QuestionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class QuestionServiceImpl implements QuestionService {

    public static ArrayList<Question> questionList;

    public QuestionServiceImpl() {
    }

    @Override
    public Question add(Question question) {
        if (questionList.contains(question)){
            throw new QuestionAlreadyExistException();
        }
        questionList.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questionList.contains(question)){
            questionList.remove(question);
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Question find(Question question) {
        if (questionList.contains(question)){
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Question getRandomQuestion() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, questionList.size());
        return questionList.get(randomNum);
    }

}
