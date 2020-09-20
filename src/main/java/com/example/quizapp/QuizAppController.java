package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizAppController {
    private List<Quiz> quizzes = new ArrayList<>();

    @GetMapping("/show")
    public List<Quiz> show() {
        return quizzes;
    }

    @PostMapping("/create")
    public void create(@RequestParam String question, @RequestParam boolean answer) {
        Quiz quiz = new Quiz(question, answer);
        quizzes.add(quiz);
    }

    @GetMapping("/check")
    public String check(@RequestParam String question, @RequestParam boolean answer) {
        // TODO: 回答が正しいかどうかチェックして、結果を返却する
        // 指定されたquestionを登録済みのクイズから検索する
        for (Quiz quiz: quizzes) {
            // もしクイズが見つかったら
            if (quiz.getQuestion().equals(question)) {
                if (quiz.isAnswer() == answer) {
                    // 登録されているanswerと回答として渡ってきたanswerが一致している場合、「正解」と返却する
                    return "正解！";
                } else {
                    // もし一致していなければ「不正解」と返却する
                    return "不正解！";
                }
            }
        }

        // クイズがみつからなかった場合は、「問題がありません」と返却する
        return "問題がありません！";
    }
}
