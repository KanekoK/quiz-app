package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizAppController {
    private List<String> quizzes = new ArrayList<>();

    @GetMapping("/show")
    public List<String> show() {
        return quizzes;
    }

    @PostMapping("/create")
    public void create(@RequestParam String question, @RequestParam boolean answer) {
        String quiz = question + ":" + answer;
        quizzes.add(quiz);
    }
}