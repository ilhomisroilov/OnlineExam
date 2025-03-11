package com.example.onlineexam;

import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tests")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public List<TestQuestion> getAllTests() {
        return testService.getQuestions();
    }

    @GetMapping("/random")
    public List<TestQuestion> getRandomTests() {
        List<TestQuestion> allTests = testService.getQuestions();
        Collections.shuffle(allTests, new Random()); // Testlarni aralashtirish
        return allTests.stream().limit(20).collect(Collectors.toList()); // 20 tasini olish
    }

    @PostMapping("/check")
    public String checkAnswers(@RequestBody Map<Integer, String> userAnswers) {
        List<TestQuestion> questions = testService.getQuestions();
        int correctCount = 0;

        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getAnswer().equals(userAnswers.get(i))) {
                correctCount++;
            }
        }

        int totalQuestions = questions.size();
        double percentage = (correctCount * 100.0) /20;

        return "Siz 20 tadan " + correctCount + " ta savolga to'g'ri javob berdingiz. " +
                "Sizning natijangiz: " + String.format("%.2f", percentage) + "%";
    }
}