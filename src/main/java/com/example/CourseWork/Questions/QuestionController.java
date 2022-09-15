package com.example.CourseWork.Questions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/java")
class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam Question question){
        return questionService.add(question);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam Question question){
        return questionService.remove(question);
    }

    @GetMapping("/find")
    public Question findQuestion(@RequestParam Question question){
        return questionService.find(question);
    }

}

