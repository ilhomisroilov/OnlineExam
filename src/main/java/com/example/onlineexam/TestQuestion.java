package com.example.onlineexam;



import java.util.List;

public class TestQuestion {
    private String question;
    private List<String> options;
    private String answer;

    public TestQuestion() {}

    public TestQuestion(String question, List<String> options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }
}
