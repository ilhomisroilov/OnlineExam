package com.example.onlineexam;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Service
public class TestService {
    private List<TestQuestion> questions;

    public TestService() {
        loadQuestions();
    }

    private void loadQuestions() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("tests.json")) {
            if (inputStream != null) {
                questions = objectMapper.readValue(inputStream, new TypeReference<List<TestQuestion>>() {});
            } else {
                questions = Collections.emptyList();
            }
        } catch (IOException e) {
            e.printStackTrace();
            questions = Collections.emptyList();
        }
    }

    public List<TestQuestion> getQuestions() {
        return questions;
    }
}
