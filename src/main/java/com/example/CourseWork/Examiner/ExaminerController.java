package com.example.CourseWork.Examiner;

import com.example.CourseWork.Questions.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
class ExaminerController {

    private final ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/getQuestions")
    public Collection<Question> getQuestions(@RequestParam int number){
        return examinerService.getQuestions(number);
    }

}

